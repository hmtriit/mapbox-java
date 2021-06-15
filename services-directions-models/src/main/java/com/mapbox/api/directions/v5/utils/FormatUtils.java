package com.mapbox.api.directions.v5.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mapbox.api.directions.v5.models.RouteOptions;
import com.mapbox.geojson.Point;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Methods to convert models to Strings.
 */
public class FormatUtils {

  /**
   * Date-time <a href="https://en.wikipedia.org/wiki/ISO_8601">ISO-8601</a> pattern.
   */
  public static final String ISO_8601_PATTERN = "yyyy-MM-dd'T'HH:mm";

  /**
   * Returns a string containing the tokens joined by delimiters. Doesn't remove trailing nulls.
   *
   * @param delimiter the delimiter on which to split.
   * @param tokens    A list of objects to be joined. Strings will be formed from the objects by
   *                  calling object.toString().
   * @return {@link String}
   */
  @Nullable
  static String join(@NonNull CharSequence delimiter, @Nullable List<?> tokens) {
    return join(delimiter, tokens, false);
  }

  /**
   * Returns a string containing the tokens joined by delimiters.
   *
   * @param delimiter           the delimiter on which to split.
   * @param tokens              A list of objects to be joined. Strings will be formed from the objects by
   *                            calling object.toString().
   * @param removeTrailingNulls true if trailing nulls should be removed.
   * @return {@link String}
   */
  @Nullable
  static String join(@NonNull CharSequence delimiter, @Nullable List<?> tokens,
                     boolean removeTrailingNulls) {
    if (tokens == null) {
      return null;
    }

    int lastNonNullToken = tokens.size() - 1;
    if (removeTrailingNulls) {
      for (int i = tokens.size() - 1; i >= 0; i--) {
        Object token = tokens.get(i);
        if (token != null) {
          break;
        } else {
          lastNonNullToken--;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    boolean firstTime = true;
    for (int i = 0; i <= lastNonNullToken; i++) {
      if (firstTime) {
        firstTime = false;
      } else {
        sb.append(delimiter);
      }
      Object token = tokens.get(i);
      if (token != null) {
        sb.append(token);
      }
    }
    return sb.toString();
  }

  /**
   * Useful to remove any trailing zeros and prevent a double being over 7 significant figures.
   *
   * @param coordinate a double value representing a coordinate.
   * @return a formatted string.
   */
  @NonNull
  public static String formatDouble(double coordinate) {
    DecimalFormat decimalFormat = new DecimalFormat("0.######",
      new DecimalFormatSymbols(Locale.US));
    return String.format(Locale.US, "%s",
      decimalFormat.format(coordinate));
  }

  /**
   * Formats the bearing variables from the raw values to a string ready for API consumption.
   *
   * @param bearings a List of list of doubles representing bearing values
   * @return a string with the bearing values
   */
  @Nullable
  public static String formatBearings(@Nullable List<List<Double>> bearings) {
    if (bearings == null) {
      return null;
    }

    List<String> bearingsToJoin = new ArrayList<>();
    for (List<Double> bearing : bearings) {
      if (bearing == null) {
        bearingsToJoin.add(null);
      } else {
        if (bearing.size() != 2) {
          throw new RuntimeException("Bearing size should be 2.");
        }

        Double angle = bearing.get(0);
        Double tolerance = bearing.get(1);
        if (angle == null || tolerance == null) {
          bearingsToJoin.add(null);
        } else {
          if (angle < 0 || angle > 360 || tolerance < 0 || tolerance > 360) {
            throw new RuntimeException("Angle and tolerance have to be from 0 to 360.");
          }

          bearingsToJoin.add(String.format(Locale.US, "%s,%s",
            formatDouble(angle),
            formatDouble(tolerance)));
        }
      }
    }
    return join(";", bearingsToJoin);
  }

  /**
   * Converts the list of distributions to a string ready for API consumption.
   *
   * @param distributions the list of integer arrays representing the distribution
   * @return a string with the distribution values
   */
  @Nullable
  public static String formatDistributions(@Nullable List<Integer[]> distributions) {
    if (distributions == null || distributions.isEmpty()) {
      return null;
    }

    List<String> distributionsToJoin = new ArrayList<>();
    for (Integer[] array : distributions) {
      if (array.length == 0) {
        distributionsToJoin.add(null);
      } else {
        distributionsToJoin.add(String.format(Locale.US, "%s,%s",
          formatDouble(array[0]),
          formatDouble(array[1])));
      }
    }
    return join(";", distributionsToJoin);
  }

  /**
   * Converts String list with approaches values to a string ready for API consumption. An approach
   * could be unrestricted, curb or null.
   *
   * @param approaches a list representing approaches to each coordinate.
   * @return a formatted string.
   */
  @Nullable
  public static String formatApproaches(@Nullable List<String> approaches) {
    if (approaches == null) {
      return null;
    }

    for (String approach : approaches) {
      if (approach != null && !approach.equals("unrestricted") && !approach.equals("curb")) {
        throw new RuntimeException(
          "Approach should be one of unrestricted or curb"
        );
      }
    }
    return join(";", approaches);
  }

  /**
   * Converts String list with waypoint_names values to a string ready for API consumption.
   *
   * @param waypointNames a string representing approaches to each coordinate.
   * @return a formatted string.
   */
  @Nullable
  public static String formatWaypointNames(@Nullable List<String> waypointNames) {
    if (waypointNames == null || waypointNames.isEmpty()) {
      return null;
    }

    return join(";", waypointNames);
  }

  /**
   * Converts a list of coordinates to a string ready for API consumption.
   *
   * @param coordinates a list of coordinates.
   * @return a formatted string.
   */
  @Nullable
  public static String formatCoordinates(@NonNull List<Point> coordinates) {
    List<String> coordinatesToJoin = new ArrayList<>();
    for (Point point : coordinates) {
      coordinatesToJoin.add(String.format(Locale.US, "%s,%s",
        formatDouble(point.longitude()),
        formatDouble(point.latitude())));
    }

    return join(";", coordinatesToJoin);
  }

  /**
   * Converts array of Points with waypoint_targets values to a string ready for API consumption.
   *
   * @param points a list representing targets to each coordinate.
   * @return a formatted string.
   * @see RouteOptions#waypointTargets()
   */
  @Nullable
  public static String formatWaypointTargets(@Nullable List<Point> points) {
    if (points == null) {
      return null;
    }

    List<String> coordinatesToJoin = new ArrayList<>();
    for (Point point : points) {
      if (point == null) {
        coordinatesToJoin.add(null);
      } else {
        coordinatesToJoin.add(String.format(Locale.US, "%s,%s",
          formatDouble(point.longitude()),
          formatDouble(point.latitude())));
      }
    }
    return join(";", coordinatesToJoin);
  }

  /**
   * Converts array of waypoint indices to a string ready for API consumption.
   *
   * @param indices a list representing indices to each coordinate.
   * @return a formatted string.
   * @see RouteOptions#waypointIndices()
   */
  @Nullable
  public static String formatWaypointIndices(@Nullable List<Integer> indices) {
    return join(";", indices);
  }

  /**
   * Converts a list of radiuses to a string ready for API consumption.
   *
   * @param radiuses a list of radiuses.
   * @return a formatted string.
   * @see RouteOptions#radiuses()
   */
  @Nullable
  public static String formatRadiuses(@Nullable List<String> radiuses) {
    if (radiuses == null) {
      return null;
    }

    for (String radius : radiuses) {
      if (!radius.equals("unlimited")) {
        double value = Double.parseDouble(radius);
        if (value < 0) {
          throw new RuntimeException(
            "Radiuses need to be greater than 0 or a string \"unlimited\"."
          );
        }
      }
    }

    return join(";", radiuses);
  }

  /**
   * Converts a list of annotation to a string ready for API consumption.
   *
   * @param annotations a list of annotations.
   * @return a formatted string.
   */
  @Nullable
  public static String formatAnnotations(@Nullable List<String> annotations) {
    return join(",", annotations);
  }

  /**
   * Converts a list of snapping include closures for each waypoint
   * to a string ready for API consumption.
   *
   * @param snappingIncludeClosures a list of allowed snappings to closures.
   * @return a formatted string.
   */
  @Nullable
  public static String formatSnappingIncludeClosures(@Nullable List<Boolean> snappingIncludeClosures) {
    return join(";", snappingIncludeClosures);
  }
}
