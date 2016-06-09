package com.kbrtz.guiaedecomer.guiaedecomer.helper;

/**
 * Created by kamila.brito on 08/06/2016.
 */
public class DbEntry {


    //TABLE NAMES
    public static final String TABLE_CONTACT = "contact";
    public static final String TABLE_CATEGORY = "catgory";
    public static final String TABLE_WORKING_HOURS = "working_hours";
    public static final String TABLE_RESTAURANT = "restaurant";
    public static final String TABLE_SERVICES = "services";
    public static final String TABLE_SPECIALS = "specials";
    public static final String TABLE_RESTAURANT_CATEGORY = "restaurant_category";
    public static final String TABLE_RESTAURANT_WORKING_HOURS = "restaurant_working_hours";
    public static final String TABLE_RESTAURANT_SPECIALS = "restaurant_specials";
    public static final String TABLE_RESTAURANT_SERVICES = "restaurant_services";
    public static final String TABLE_SPECIAL_WORKING_HOURS = "special_working_hours";
    public static final String TABLE_SERVICE_WORKING_HOURS = "service_working_hours";

    //CONTACT FIELDS
    public static final String CONTACT_ID= "contact_id";
    public static final String CONTACT_FACEBOOK= "facebook";
    public static final String CONTACT_TWITTER= "twitter";
    public static final String CONTACT_INSTAGRAM= "instagram";
    public static final String CONTACT_PHONE= "phone";
    public static final String CONTACT_WEBSITE= "website";

    //CATEGORY FIELDS
    public static final String CATEGORY_ID= "category_id";
    public static final String CATEGORY_NAME= "name";

    //RESTAURANT FIELDS
    public static final String RESTAURANT_ID= "restaurant_id";
    public static final String RESTAURANT_NAME= "name";
    public static final String RESTAURANT_ADDRESS= "address";
    public static final String RESTAURANT_HEADER_PHOTO= "header_photo";
    public static final String RESTAURANT_CONTACT_ID= "restaurant_contact_id";

    //SPECIALS FIELDS
    public static final String SPECIALS_ID= "specials_id";
    public static final String SPECIALS_NAME= "name";
    public static final String SPECIALS_DESCRIPTION= "description";

    //SERVICES FIELDS
    public static final String SERVICES_ID= "services_id";
    public static final String SERVICES_NAME= "name";
    public static final String SERVICES_PRICE= "price";
    public static final String SERVICES_FREE= "free";

    //WORKING HOURS FIELDS
    public static final String WORKING_HOURS_ID= "workinghours_id";
    public static final String WORKING_HOURS_WEEKDAY= "week_day";
    public static final String WORKING_HOURS_HOUR_START= "hour_start";
    public static final String WORKING_HOURS_HOUR_FINISH= "hour_finish";



}
