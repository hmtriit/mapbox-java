package com.mapbox.api.directions.v5;

import androidx.annotation.IntDef;
import androidx.annotation.StringDef;
import com.mapbox.api.directions.v5.models.Amenity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Constants and properties used to customize the directions request.
 *
 * @since 1.0.0
 */
public final class DirectionsCriteria {

  /**
   * Mapbox default username.
   *
   * @since 1.0.0
   */
  public static final String PROFILE_DEFAULT_USER = "mapbox";

  /**
   * Base URL for all API calls.
   */
  public static final String BASE_API_URL = "https://api.mapbox.com";

  /**
   * For car and motorcycle routing. This profile factors in current and historic traffic
   * conditions to avoid slowdowns.
   *
   * @since 2.0.0
   */
  public static final String PROFILE_DRIVING_TRAFFIC = "driving-traffic";

  /**
   * For car and motorcycle routing. This profile shows the fastest routes by preferring
   * high-speed roads like highways.
   *
   * @since 1.0.0
   */
  public static final String PROFILE_DRIVING = "driving";

  /**
   * For pedestrian and hiking routing. This profile shows the shortest path by using sidewalks
   * and trails.
   *
   * @since 1.0.0
   */
  public static final String PROFILE_WALKING = "walking";

  /**
   * For bicycle routing. This profile shows routes that are short and safe for cyclist, avoiding
   * highways and preferring streets with bike lanes.
   *
   * @since 1.0.0
   */
  public static final String PROFILE_CYCLING = "cycling";

  /**
   * Format to return route geometry will be an encoded polyline.
   *
   * @since 1.0.0
   */
  public static final String GEOMETRY_POLYLINE = "polyline";

  /**
   * Format to return route geometry will be an encoded polyline with precision 6.
   *
   * @since 2.0.0
   */
  public static final String GEOMETRY_POLYLINE6 = "polyline6";

  /**
   * A simplified version of the {@link #OVERVIEW_FULL} geometry. If not specified simplified is
   * the default.
   *
   * @since 1.0.0
   */
  public static final String OVERVIEW_SIMPLIFIED = "simplified";

  /**
   * The most detailed geometry available.
   *
   * @since 1.0.0
   */
  public static final String OVERVIEW_FULL = "full";

  /**
   * No overview geometry.
   *
   * @since 1.0.0
   */
  public static final String OVERVIEW_FALSE = "false";

  /**
   * The duration between each pair of coordinates in seconds.
   *
   * @since 2.1.0
   */
  public static final String ANNOTATION_DURATION = "duration";

  /**
   * The distance between each pair of coordinates in meters.
   *
   * @since 2.1.0
   */
  public static final String ANNOTATION_DISTANCE = "distance";

  /**
   * The speed between each pair of coordinates in meters per second.
   *
   * @since 2.1.0
   */
  public static final String ANNOTATION_SPEED = "speed";

  /**
   * The level of congestion between each entry in the array of coordinate pairs
   * in the route leg.
   * This annotation is only available for the {@link DirectionsCriteria#PROFILE_DRIVING_TRAFFIC}.
   */
  public static final String ANNOTATION_CONGESTION = "congestion";

  /**
   * The numeric level of congestion between each entry in the array of coordinate pairs
   * in the route leg.
   * This annotation is only available for the {@link DirectionsCriteria#PROFILE_DRIVING_TRAFFIC}.
   */
  public static final String ANNOTATION_CONGESTION_NUMERIC = "congestion_numeric";

  /**
   * The maximum speed limit between the coordinates of a segment.
   * This annotation is only available for
   * the {@link DirectionsCriteria#PROFILE_DRIVING} and
   * the {@link DirectionsCriteria#PROFILE_DRIVING_TRAFFIC}.
   */
  public static final String ANNOTATION_MAXSPEED = "maxspeed";

  /**
   * An array of closure objects describing live-traffic related closures
   * that occur along the route.
   * This annotation is only available for
   * the {@link DirectionsCriteria#PROFILE_DRIVING_TRAFFIC}.
   */
  public static final String ANNOTATION_CLOSURE = "closure";

  /*
   * The tendency value conveys the changing
   * state of traffic congestion (increasing, decreasing, constant etc).
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final String ANNOTATION_TRAFFIC_TENDENCY = "traffic_tendency";

  /**
   * Exclude all tolls along the returned directions route.
   *
   * @since 3.0.0
   */
  public static final String EXCLUDE_TOLL = "toll";

  /**
   * Exclude all motorways along the returned directions route.
   *
   * @since 3.0.0
   */
  public static final String EXCLUDE_MOTORWAY = "motorway";

  /**
   * Exclude all ferries along the returned directions route.
   *
   * @since 3.0.0
   */
  public static final String EXCLUDE_FERRY = "ferry";

  /**
   * Exclude all tunnels along the returned directions route.
   *
   * @since 3.0.0
   */
  public static final String EXCLUDE_TUNNEL = "tunnel";

  /**
   * Exclude all roads with access restrictions along the returned directions route.
   *
   * @since 3.0.0
   */
  public static final String EXCLUDE_RESTRICTED = "restricted";

  /**
   * Exclude all cash only tolls along the returned directions route.
   */
  public static final String EXCLUDE_CASH_ONLY_TOLLS = "cash_only_tolls";

  /**
   * Exclude all unpaved roads along the returned directions route.
   */
  public static final String EXCLUDE_UNPAVED = "unpaved";

  /**
   * A road type that requires a minimum of two vehicle occupants.
   */
  public static final String INCLUDE_HOV2 = "hov2";

  /**
   * A road type that requires a minimum of three vehicle occupants.
   */
  public static final String INCLUDE_HOV3 = "hov3";

  /**
   * An hov road that is tolled if your vehicle doesn't meet the minimum occupant requirement.
   */
  public static final String INCLUDE_HOT = "hot";

  /**
   * Change the units to imperial for voice and visual information. Note that this won't change
   * other results such as raw distance measurements which will always be returned in meters.
   *
   * @since 3.0.0
   */
  public static final String IMPERIAL = "imperial";

  /**
   * Change the units to metric for voice and visual information. Note that this won't change
   * other results such as raw distance measurements which will always be returned in meters.
   *
   * @since 3.0.0
   */
  public static final String METRIC = "metric";

  /**
   * Returned route starts at the first provided coordinate in the list. Used specifically for the
   * Optimization API.
   *
   * @since 2.1.0
   */
  public static final String SOURCE_FIRST = "first";

  /**
   * Returned route starts at any of the provided coordinate in the list. Used specifically for the
   * Optimization API.
   *
   * @since 2.1.0
   */
  public static final String SOURCE_ANY = "any";


  /**
   * Returned route ends at any of the provided coordinate in the list. Used specifically for the
   * Optimization API.
   *
   * @since 3.0.0
   */
  public static final String DESTINATION_ANY = "any";

  /**
   * Returned route ends at the last provided coordinate in the list. Used specifically for the
   * Optimization API.
   *
   * @since 3.0.0
   */
  public static final String DESTINATION_LAST = "last";

  /**
   * The routes can approach waypoints from either side of the road. <p>
   * <p>
   * Used in MapMatching and Directions API.
   *
   * @since 3.2.0
   */
  public static final String APPROACH_UNRESTRICTED = "unrestricted";

  /**
   * The route will be returned so that on arrival,
   * the waypoint will be found on the side that corresponds with the driving_side of
   * the region in which the returned route is located.
   *
   * @since 3.2.0
   */
  public static final String APPROACH_CURB = "curb";

  /*
   * Conveys the changing state of traffic congestion: unknown.
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final int TRAFFIC_TENDENCY_UNKNOWN = 0;

  /*
   * Conveys the changing state of traffic congestion: constant.
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final int TRAFFIC_TENDENCY_CONSTANT_CONGESTION = 1;

  /*
   * Conveys the changing state of traffic congestion: increasing.
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final int TRAFFIC_TENDENCY_INCREASING_CONGESTION = 2;

  /*
   * Conveys the changing state of traffic congestion: decreasing.
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final int TRAFFIC_TENDENCY_DECREASING_CONGESTION = 3;

  /*
   * Conveys the changing state of traffic congestion: rapidly increasing.
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final int TRAFFIC_TENDENCY_RAPIDLY_INCREASING_CONGESTION = 4;

  /*
   * Conveys the changing state of traffic congestion: rapidly decreasing.
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final int TRAFFIC_TENDENCY_RAPIDLY_DECREASING_CONGESTION = 5;

  /*
   * Used in Japan for all payments other than transponder such as ETC or ETCX.
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final String PAYMENT_METHOD_GENERAL = "general";

  /*
   * A transponder in any country, for any transponder system (e.g. EZ-PASS, Peach Pass).
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final String PAYMENT_METHOD_ETC = "etc";

  /*
   * A transponder only used for several specific roads in Japan.
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final String PAYMENT_METHOD_ETCX = "etcx";

  /*
   * Payment can be done in cash (coins or notes) of the locally common currency.
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final String PAYMENT_METHOD_CASH = "cash";

  /*
   * Exact cash payment or tokens at a toll structure.
   * Tokens are pre-purchased coins used to pay toll.
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final String PAYMENT_METHOD_EXACT_CASH = "exact_cash";

  /*
   * Payment can be done by coins.
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final String PAYMENT_METHOD_COINS = "coins";

  /*
   * Payment can be done by notes (paper money).
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final String PAYMENT_METHOD_NOTES = "notes";

  /*
   * Payment can be done with common debit cards.
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final String PAYMENT_METHOD_DEBIT_CARDS = "debit_cards";

  /*
   * A pre-purchased pass or subscription.
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final String PAYMENT_METHOD_PASS_CARD = "pass_card";

  /*
   * Payment can be done with common credit cards.
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final String PAYMENT_METHOD_CREDIT_CARDS = "credit_cards";

  /*
   * Automatic monitor of vehicles that enter the toll road without a transponder.
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final String PAYMENT_METHOD_VIDEO = "video";

  /*
   * Generic tag for any cryptocurrency.
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final String PAYMENT_METHOD_CRYPTOCURRENCIES = "cryptocurrencies";

  /*
   * Payment possible via phone or other personal device's app
   * (e.g. Bluetooth, barcode, CR code, etc.).
   */
  @SuppressWarnings("checkstyle:javadocvariable")
  public static final String PAYMENT_METHOD_APP = "app";

  /**
   * Gas station amenity type.
   */
  public static final String AMENITY_TYPE_GAS_STATION = "gas_station";
  /**
   * Electric charging station amenity type.
   */
  public static final String AMENITY_TYPE_ELECTRIC_CHARGING_STATION = "electric_charging_station";
  /**
   * Toilet amenity type.
   */
  public static final String AMENITY_TYPE_TOILET = "toilet";
  /**
   * Coffee amenity type.
   */
  public static final String AMENITY_TYPE_COFFEE = "coffee";
  /**
   * Restaurant amenity type.
   */
  public static final String AMENITY_TYPE_RESTAURANT = "restaurant";
  /**
   * Snack amenity type.
   */
  public static final String AMENITY_TYPE_SNACK = "snack";
  /**
   * ATM amenity type.
   */
  public static final String AMENITY_TYPE_ATM = "ATM";
  /**
   * Info amenity type.
   */
  public static final String AMENITY_TYPE_INFO = "info";
  /**
   * Baby care amenity type.
   */
  public static final String AMENITY_TYPE_BABY_CARE = "baby_care";
  /**
   * Facilities for disabled amenity type.
   */
  public static final String AMENITY_TYPE_FACILITIES_FOR_DISABLED = "facilities_for_disabled";
  /**
   * Shop amenity type.
   */
  public static final String AMENITY_TYPE_SHOP = "shop";
  /**
   * Telephone amenity type.
   */
  public static final String AMENITY_TYPE_TELEPHONE = "telephone";
  /**
   * Hotel amenity type.
   */
  public static final String AMENITY_TYPE_HOTEL = "hotel";
  /**
   * Hotspring amenity type.
   */
  public static final String AMENITY_TYPE_HOTSPRING = "hotspring";
  /**
   * Shower amenity type.
   */
  public static final String AMENITY_TYPE_SHOWER = "shower";
  /**
   * Picnic shelter amenity type.
   */
  public static final String AMENITY_TYPE_PICNIC_SHELTER = "picnic_shelter";
  /**
   * Post amenity type.
   */
  public static final String AMENITY_TYPE_POST = "post";
  /**
   * FAX amenity type.
   */
  public static final String AMENITY_TYPE_FAX = "FAX";

  private DirectionsCriteria() {
    //not called
  }

  /**
   * Retention policy for the various direction profiles.
   *
   * @since 3.0.0
   */
  @Retention(RetentionPolicy.CLASS)
  @StringDef( {
    PROFILE_DRIVING_TRAFFIC,
    PROFILE_DRIVING,
    PROFILE_WALKING,
    PROFILE_CYCLING
  })
  public @interface ProfileCriteria {
  }

  /**
   * Retention policy for the various direction geometries.
   *
   * @since 3.0.0
   */
  @Retention(RetentionPolicy.CLASS)
  @StringDef( {
    GEOMETRY_POLYLINE,
    GEOMETRY_POLYLINE6
  })
  public @interface GeometriesCriteria {
  }

  /**
   * Retention policy for the various direction overviews.
   *
   * @since 3.0.0
   */
  @Retention(RetentionPolicy.CLASS)
  @StringDef( {
    OVERVIEW_FALSE,
    OVERVIEW_FULL,
    OVERVIEW_SIMPLIFIED
  })
  public @interface OverviewCriteria {
  }

  /**
   * Retention policy for the various direction annotations.
   *
   * @since 3.0.0
   */
  @Retention(RetentionPolicy.CLASS)
  @StringDef( {
    ANNOTATION_DURATION,
    ANNOTATION_DISTANCE,
    ANNOTATION_SPEED,
    ANNOTATION_CONGESTION,
    ANNOTATION_CONGESTION_NUMERIC,
    ANNOTATION_MAXSPEED,
    ANNOTATION_CLOSURE,
    ANNOTATION_TRAFFIC_TENDENCY
  })
  public @interface AnnotationCriteria {
  }

  /**
   * Retention policy for the various direction exclusions.
   *
   * @since 3.0.0
   */
  @Retention(RetentionPolicy.CLASS)
  // Please update Exclude.VALID_EXCLUDE_CRITERIA adding new type of exclude
  @StringDef( {
    EXCLUDE_FERRY,
    EXCLUDE_MOTORWAY,
    EXCLUDE_TOLL,
    EXCLUDE_TUNNEL,
    EXCLUDE_RESTRICTED,
    EXCLUDE_CASH_ONLY_TOLLS,
    EXCLUDE_UNPAVED
  })
  public @interface ExcludeCriteria {
  }

  /**
   * Retention policy for include key.
   */
  @Retention(RetentionPolicy.CLASS)
  @StringDef( {
    INCLUDE_HOV2,
    INCLUDE_HOV3,
    INCLUDE_HOT
  })
  public @interface IncludeCriteria {
  }

  /**
   * Retention policy for the various units of measurements.
   *
   * @since 0.3.0
   */
  @Retention(RetentionPolicy.CLASS)
  @StringDef( {
    IMPERIAL,
    METRIC
  })
  public @interface VoiceUnitCriteria {
  }

  /**
   * Retention policy for the source parameter in the Optimization API.
   *
   * @since 3.0.0
   */
  @Retention(RetentionPolicy.CLASS)
  @StringDef( {
    SOURCE_ANY,
    SOURCE_FIRST
  })
  public @interface SourceCriteria {
  }

  /**
   * Retention policy for the destination parameter in the Optimization API.
   *
   * @since 3.0.0
   */
  @Retention(RetentionPolicy.CLASS)
  @StringDef( {
    DESTINATION_ANY,
    DESTINATION_LAST
  })
  public @interface DestinationCriteria {
  }


  /**
   * Retention policy for the approaches parameter in the MapMatching and Directions API.
   *
   * @since 3.2.0
   */
  @Retention(RetentionPolicy.CLASS)
  @StringDef( {
    APPROACH_UNRESTRICTED,
    APPROACH_CURB
  })
  public @interface ApproachesCriteria {
  }

  /*
   * Retention policy for the traffic tendency annotations.
   * The tendency value conveys the changing state of traffic
   * congestion (increasing, decreasing, constant etc). New values
   * could be introduced in the future without an API version change.
   */
  @SuppressWarnings("checkstyle:javadoctype")
  @Retention(RetentionPolicy.CLASS)
  @IntDef({
    TRAFFIC_TENDENCY_UNKNOWN,
    TRAFFIC_TENDENCY_CONSTANT_CONGESTION,
    TRAFFIC_TENDENCY_INCREASING_CONGESTION,
    TRAFFIC_TENDENCY_DECREASING_CONGESTION,
    TRAFFIC_TENDENCY_RAPIDLY_INCREASING_CONGESTION,
    TRAFFIC_TENDENCY_RAPIDLY_DECREASING_CONGESTION
  })
  public @interface TrafficTendencyCriteria {
  }

  /*
   * Supported payment methods. See {@link RouteOptions#paymentMethods()}.
   */
  @SuppressWarnings("checkstyle:javadoctype")
  @Retention(RetentionPolicy.CLASS)
  @StringDef({
    PAYMENT_METHOD_GENERAL,
    PAYMENT_METHOD_ETC,
    PAYMENT_METHOD_ETCX,
    PAYMENT_METHOD_CASH,
    PAYMENT_METHOD_EXACT_CASH,
    PAYMENT_METHOD_COINS,
    PAYMENT_METHOD_NOTES,
    PAYMENT_METHOD_DEBIT_CARDS,
    PAYMENT_METHOD_PASS_CARD,
    PAYMENT_METHOD_CREDIT_CARDS,
    PAYMENT_METHOD_VIDEO,
    PAYMENT_METHOD_CRYPTOCURRENCIES,
    PAYMENT_METHOD_APP,
  })
  public @interface PaymentMethodsCriteria {
  }

  /**
   * Supported amenity types. See {@link Amenity#type()}.
   */
  @Retention(RetentionPolicy.CLASS)
  @StringDef({
    AMENITY_TYPE_GAS_STATION,
    AMENITY_TYPE_ELECTRIC_CHARGING_STATION,
    AMENITY_TYPE_TOILET,
    AMENITY_TYPE_COFFEE,
    AMENITY_TYPE_RESTAURANT,
    AMENITY_TYPE_SNACK,
    AMENITY_TYPE_ATM,
    AMENITY_TYPE_INFO,
    AMENITY_TYPE_BABY_CARE,
    AMENITY_TYPE_FACILITIES_FOR_DISABLED,
    AMENITY_TYPE_SHOP,
    AMENITY_TYPE_TELEPHONE,
    AMENITY_TYPE_HOTEL,
    AMENITY_TYPE_HOTSPRING,
    AMENITY_TYPE_SHOWER,
    AMENITY_TYPE_PICNIC_SHELTER,
    AMENITY_TYPE_POST,
    AMENITY_TYPE_FAX,
  })
  public @interface AmenityTypeCriteria {
  }
}
