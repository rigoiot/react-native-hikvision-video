package com.hcnetsdk.jna;

import java.util.Arrays;
import java.util.List;

import com.hikvision.netsdk.EAP_TTLS;
import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;

public interface HCNetSDKByJNA extends Library {

	// command begin
	public static final int NET_DVR_GET_TIMECFG = 118;
	public static final int NET_DVR_SET_TIMECFG = 119;
	//public static final int NET_DVR_GET_NTPCFG = 224; //jni
	//public static final int NET_DVR_SET_NTPCFG = 225;	//jni/**Set network application parameters(NTP)*/
	//public static final int NET_DVR_GET_DEVICECFG_V40             = 1100; //jni
	//public static final int NET_DVR_SET_DEVICECFG_V40             = 1101; //jni
	//public static final int NET_DVR_GET_NETCFG_V30	              = 1000; //jni
	//public static final int NET_DVR_SET_NETCFG_V30	              = 1001; //jni
	//public static final int NET_DVR_SET_WIFI_CFG                  = 306;  //jni
	//public static final int NET_DVR_GET_WIFI_CFG                  = 307;  //jni
	//public static final int NET_DVR_GET_AP_INFO_LIST              = 305;  //jni 
	//public static final int NET_DVR_GET_WIFI_STATUS	              = 310;  //jni
	public static final int NET_DVR_GET_WEEK_PLAN_CFG             = 2100; //get week plan of door
	public static final int NET_DVR_SET_WEEK_PLAN_CFG             = 2101; //set week plan of door
	public static final int NET_DVR_GET_ACS_WORK_STATUS           = 2123;
	public static final int NET_DVR_GET_VERIFY_WEEK_PLAN          = 2124;
	public static final int NET_DVR_SET_VERIFY_WEEK_PLAN          = 2125;
	public static final int NET_DVR_GET_CARD_RIGHT_WEEK_PLAN      = 2126;
	public static final int NET_DVR_SET_CARD_RIGHT_WEEK_PLAN      = 2127;
	public static final int NET_DVR_GET_CARD_RIGHT_WEEK_PLAN_V50  = 2304;
	public static final int NET_DVR_SET_CARD_RIGHT_WEEK_PLAN_V50  = 2305;
	public static final int NET_DVR_GET_DOOR_STATUS_HOLIDAY_PLAN  = 2102;
	public static final int NET_DVR_SET_DOOR_STATUS_HOLIDAY_PLAN  = 2103;
	public static final int NET_DVR_GET_VERIFY_HOLIDAY_PLAN       = 2128;
	public static final int NET_DVR_SET_VERIFY_HOLIDAY_PLAN       = 2129;
	public static final int NET_DVR_GET_CARD_RIGHT_HOLIDAY_PLAN   = 2130;
	public static final int NET_DVR_SET_CARD_RIGHT_HOLIDAY_PLAN   = 2131;
	public static final int NET_DVR_GET_CARD_RIGHT_HOLIDAY_PLAN_V50 = 2310;
	public static final int NET_DVR_SET_CARD_RIGHT_HOLIDAY_PLAN_V50 = 2311;
	public static final int NET_DVR_GET_DOOR_STATUS_HOLIDAY_GROUP = 2104;
	public static final int NET_DVR_SET_DOOR_STATUS_HOLIDAY_GROUP = 2105;
	public static final int NET_DVR_GET_VERIFY_HOLIDAY_GROUP      = 2132;
	public static final int NET_DVR_SET_VERIFY_HOLIDAY_GROUP      = 2133;
	public static final int NET_DVR_GET_CARD_RIGHT_HOLIDAY_GROUP  = 2134;
	public static final int NET_DVR_SET_CARD_RIGHT_HOLIDAY_GROUP  = 2135;
	public static final int NET_DVR_GET_CARD_RIGHT_HOLIDAY_GROUP_V50  = 2316;
	public static final int NET_DVR_SET_CARD_RIGHT_HOLIDAY_GROUP_V50  = 2317;
	public static final int NET_DVR_GET_DOOR_STATUS_PLAN_TEMPLATE = 2106;
	public static final int NET_DVR_SET_DOOR_STATUS_PLAN_TEMPLATE = 2107;
	public static final int NET_DVR_GET_VERIFY_PLAN_TEMPLATE      = 2136;
	public static final int NET_DVR_SET_VERIFY_PLAN_TEMPLATE      = 2137;
	public static final int NET_DVR_GET_CARD_RIGHT_PLAN_TEMPLATE  = 2138;
	public static final int NET_DVR_SET_CARD_RIGHT_PLAN_TEMPLATE  = 2139;
	public static final int NET_DVR_GET_CARD_RIGHT_PLAN_TEMPLATE_V50 = 2322;
	public static final int NET_DVR_SET_CARD_RIGHT_PLAN_TEMPLATE_V50 = 2323;
	public static final int NET_DVR_GET_DOOR_CFG                  = 2108;
	public static final int NET_DVR_SET_DOOR_CFG                  = 2109;
	public static final int NET_DVR_GET_CARD_READER_CFG_V50	      = 2505;
	public static final int NET_DVR_SET_CARD_READER_CFG_V50       = 2506;
	public static final int NET_DVR_GET_ACS_WORK_STATUS_V50	      = 2180;
	public static final int NET_DVR_SET_WIFI_WORKMODE             = 308;
	public static final int NET_DVR_GET_WIFI_WORKMODE             = 309;
	public static final int NET_DVR_CLEAR_ACS_PARAM	              = 2118;
	public static final int NET_DVR_COMPLETE_RESTORE_CTRL         = 3420;
	public static final int NET_DVR_GET_CARD_CFG = 2116;

	public static final int NET_DVR_VIDEO_CALL_SIGNAL_PROCESS = 16032;

	public static final int NET_DVR_GET_ALARMHOSTSUBSYSTEM_CFG = 2001;
	public static final int NET_DVR_SET_ALARMHOSTSUBSYSTEM_CFG = 2002;

	public static final int NET_DVR_GET_ALARMHOST_OTHER_STATUS_V50 = 2228;

	public static final int NET_DVR_GET_MULTI_STREAM_COMPRESSIONCFG = 3216;
	public static final int NET_DVR_SET_MULTI_STREAM_COMPRESSIONCFG = 3217;

	public static final int NET_DVR_START_GET_INPUTVOLUME = 3370;

	public static final int NET_DVR_GET_LOITERING_DETECTION = 3521;
	public static final int NET_DVR_SET_LOITERING_DETECTION = 3522;

	public static final int NET_DVR_GET_LED_AREA_INFO_LIST = 9295;

	public static final int NET_DVR_MATRIX_GETWINSTATUS = 9009;

	public static final int NET_SDK_GET_INPUTSTREAMCFG = 1551;

	public static final int NET_DVR_GET_EZVIZ_ACCESS_CFG = 3398;
	public static final int NET_DVR_SET_EZVIZ_ACCESS_CFG = 3399;


	public static final int NET_SDK_GET_VIDEOWALLDISPLAYNO  = 1553;

	public static final int  NET_SDK_GET_ALLSUBSYSTEM_BASIC_INFO =1554;

	public static final int  NET_SDK_SET_ALLSUBSYSTEM_BASIC_INFO = 1555;

	public static final int NET_SDK_GET_AUDIO_INFO =1556;

	public static final int NET_DVR_GET_VIDEOWALLDISPLAYNO  = 1732;

	public static final int NET_DVR_SET_VIDEOWALLDISPLAYPOSITION =1733;

	public static final int NET_DVR_GET_VIDEOWALLDISPLAYPOSITION =1734;

	public static final int NET_DVR_GET_CURTRIGGERMODE = 3130;

	public static final int NET_ITC_GET_RS485_ACCESSINFO = 3117;

	public static final int NET_ITC_SET_RS485_ACCESSINFO = 3118;

	public static final int NET_DVR_GET_SHOWSTRING_V30 = 1030;

	public static final int NET_DVR_SET_SHOWSTRING_V30 = 1031;

	public static final int NET_ITS_GET_OVERLAP_CFG = 5072;

	public static final int NET_ITS_SET_OVERLAP_CFG = 5073;

	public static final int NET_ITC_GET_TRIGGERCFG = 3003;

	public static final int NET_ITC_SET_TRIGGERCFG = 3004;



	// command end

	//alarm type
	public static final int COMM_ALARM_RULE = 0x1102;
	public static final int COMM_ALARM_PDC = 0x1103;
	public static final int COMM_UPLOAD_FACESNAP_RESULT = 0x1112;
	public static final int COMM_UPLOAD_PLATE_RESULT = 0x2800;
	public static final int COMM_SNAP_MATCH_ALARM = 0x2902;
	public static final int COMM_ITS_PLATE_RESULT = 0x3050;
	public static final int COMM_VEHICLE_CONTROL_ALARM = 0x3059;
	public static final int COMM_ALARM_V30 = 0x4000;
	public static final int COMM_ALARM_V40 = 0x4007;
	public static final int COMM_ALARM_FACE_DETECTION = 0x4010;
	//alarm type end

	public static final int NET_DVR_DEV_ADDRESS_MAX_LEN = 129;
	public static final int NET_DVR_LOGIN_USERNAME_MAX_LEN = 64;
	public static final int NET_DVR_LOGIN_PASSWD_MAX_LEN = 64;
	public static final int NET_SDK_CALLBACK_TYPE_STATUS = 0;
	public static final int NET_SDK_CALLBACK_TYPE_PROGRESS = 1;
	public static final int NET_SDK_CALLBACK_TYPE_DATA = 2;

	public static final int NET_SDK_CALLBACK_STATUS_SUCCESS = 1000;
	public static final int NET_SDK_CALLBACK_STATUS_PROCESSING = 1001;
	public static final int NET_SDK_CALLBACK_STATUS_FAILED = 1002;
	public static final int NET_SDK_CALLBACK_STATUS_EXCEPTION = 1003;
	public static final int NET_SDK_CALLBACK_STATUS_LANGUAGE_MISMATCH = 1004;
	public static final int NET_SDK_CALLBACK_STATUS_DEV_TYPE_MISMATCH = 1005;
	public static final int NET_DVR_CALLBACK_STATUS_SEND_WAIT = 1006;

	public static final int ACS_CARD_NO_LEN = 32;
	public static final int CARD_PASSWORD_LEN = 8;
	public static final int MAX_DOOR_NUM = 32;
	public static final int MAX_CARD_RIGHT_PLAN_NUM = 4;

	public static final int STREAM_ID_LEN = 32;
	public static final int SERIALNO_LEN = 48;
	public static final int NAME_LEN = 32;
	public static final int MACADDR_LEN = 6;
	public static final int MAX_DISKNUM_V30 = 33;
	public static final int MAX_DISKNUM = 16;
	public static final int MAX_LICENSE_LEN = 16;

	public static final int MAX_HUMAN_BIRTHDATE_LEN = 10;

	public static final int MAX_CHANNUM = 16;
	public static final int MAX_ALARMIN = 16;
	public static final int MAX_ALARMOUT = 4;

	public static final int MAX_ANALOG_CHANNUM = 32;
	public static final int MAX_ANALOG_ALARMOUT = 32;
	public static final int MAX_ANALOG_ALARMIN = 32;
	public static final int MAX_IP_DEVICE = 32;
	public static final int MAX_IP_CHANNEL = 32;
	public static final int MAX_IP_ALARMIN = 128;
	public static final int MAX_IP_ALARMOUT = 64;

	public static final int MAX_CHANNUM_V30 = (MAX_ANALOG_CHANNUM + MAX_IP_CHANNEL);// 64
	public static final int MAX_ALARMOUT_V30 = (MAX_ANALOG_ALARMOUT + MAX_IP_ALARMOUT);// 96
	public static final int MAX_ALARMIN_V30 = (MAX_ANALOG_ALARMIN + MAX_IP_ALARMIN);// 160

	public static final int VCA_MAX_POLYGON_POINT_NUM = 10;
	public static final int MAX_REGION_NUM = 8;
	public static final int MAX_NUM_OUTPUT_CHANNEL = 512;

	public static final int MAX_DISPLAY_NUM = 512;

	public static final int ALARMHOST_MAX_SIREN_NUM = 8;
	public static final int MAX_DETECTOR_NUM = 128;
	public static final int ENUM_VCA_EVENT_TRAVERSE_PLANE      		= 1;
	public static final int ENUM_VCA_EVENT_ENTER_AREA         		= 2;
	public static final int ENUM_VCA_EVENT_EXIT_AREA           		= 3;
	public static final int ENUM_VCA_EVENT_INTRUSION      			= 4;
	public static final int ENUM_VCA_EVENT_LOITER     				= 5;
	public static final int ENUM_VCA_EVENT_LEFT_TAKE           		= 6;
	public static final int ENUM_VCA_EVENT_PARKING             		= 7;
	public static final int ENUM_VCA_EVENT_RUN            			= 8;
	public static final int ENUM_VCA_EVENT_HIGH_DENSITY        		= 9;
	public static final int ENUM_VCA_EVENT_VIOLENT_MOTION      		= 10;
	public static final int ENUM_VCA_EVENT_REACH_HIGHT         		= 11;
	public static final int ENUM_VCA_EVENT_GET_UP              		= 12;
	public static final int ENUM_VCA_EVENT_LEFT                		= 13;
	public static final int ENUM_VCA_EVENT_TAKE                		= 14;
	public static final int ENUM_VCA_EVENT_LEAVE_POSITION      		= 15;
	public static final int ENUM_VCA_EVENT_TRAIL               		= 16;
	public static final int ENUM_VCA_EVENT_KEY_PERSON_GET_UP   		= 17;
	public static final int ENUM_VCA_EVENT_STANDUP             		= 18;
	public static final int ENUM_VCA_EVENT_FALL_DOWN                = 20;
	public static final int ENUM_VCA_EVENT_AUDIO_ABNORMAL      		= 21;
	public static final int ENUM_VCA_EVENT_ADV_REACH_HEIGHT    		= 22;
	public static final int ENUM_VCA_EVENT_TOILET_TARRY        		= 23;
	public static final int ENUM_VCA_EVENT_YARD_TARRY          		= 24;
	public static final int ENUM_VCA_EVENT_ADV_TRAVERSE_PLANE  		= 25;
	public static final int ENUM_VCA_EVENT_HUMAN_ENTER         		= 29;
	public static final int ENUM_VCA_EVENT_OVER_TIME           		= 30;
	public static final int ENUM_VCA_EVENT_STICK_UP            		= 31;
	public static final int ENUM_VCA_EVENT_INSTALL_SCANNER     		= 32;
	public static final int ENUM_VCA_EVENT_PEOPLENUM_CHANGE    		= 35;
	public static final int ENUM_VCA_EVENT_SPACING_CHANGE      		= 36;
	public static final int ENUM_VCA_EVENT_COMBINED_RULE       		= 37;
	public static final int ENUM_VCA_EVENT_SIT_QUIETLY         		= 38;
	public static final int ENUM_VCA_EVENT_HIGH_DENSITY_STATUS 		= 39;


	public static final int MAX_SUBSYSTEM_ID_LEN = 16;
	public static final int ACCOUNTNUM_LEN = 6;
	public static final int ACCOUNTNUM_LEN_32 = 32;


	public static final int EZVIZ_DEVICEID_LEN = 32;
	public static final int EZVIZ_REQURL_LEN = 64;
	public static final int EZVIZ_ACCESSTOKEN_LEN = 128;
	public static final int EZVIZ_CLIENTTYPE_LEN = 32;
	public static final int EZVIZ_FEATURECODE_LEN = 64;
	public static final int EZVIZ_OSVERSION_LEN = 32;
	public static final int EZVIZ_NETTYPE_LEN = 32;
	public static final int EZVIZ_SDKVERSION_LEN = 32;
	public static final int EZVIZ_APPID_LEN = 64;

	public static final int MAX_DOMAIN_NAME = 64;
	public static final int PASSWD_LEN = 16;
	public static final int MAX_CARDNO_LEN = 48;

	public static final int NET_SDK_MAX_VERIFICATION_CODE_LEN = 32;

	public static final int NET_SDK_MAX_FDID_LEN = 256;
	public static final int MAX_UPLOADFILE_URL_LEN = 260;
	public static final int NET_SDK_MAX_PICID_LEN = 256;

	public static final int ENUM_DVR_VEHICLE_CHECK = 1;
	public static final int ENUM_MSC_SEND_DATA = 2;
	public static final int ENUM_ACS_SEND_DATA =3;
	public static final int ENUM_TME_CARD_SEND_DATA = 4;
	public static final int ENUM_TME_VEHICLE_SEND_DATA = 5;
	public static final int ENUM_DVR_DEBUG_CMD = 6;
	public static final int ENUM_DVR_SCREEN_CTRL_CMD =7;
	public static final int ENUM_CVR_PASSBACK_SEND_DATA = 8;

	public static final int ISAPI_DATA_LEN = 10*1024*1024;
	public static final int ISAPI_STATUS_LEN = 4*4096;
	public static final int BYTE_ARRAY_LEN = 1024;

	public static final int MAX_MAX_ALARMIN_NUM = 64;
	public static final int MAX_DAYS = 7;
	public static final int MAX_TIMESEGMENT_V30 = 8;
	public static final int HOLIDAY_GROUP_NAME_LEN = 32;
	public static final int MAX_HOLIDAY_PLAN_NUM = 16;
	public static final int TEMPLATE_NAME_LEN = 32;
	public static final int MAX_HOLIDAY_GROUP_NUM = 16;
	public static final int DEV_TYPE_NAME_LEN = 64;
	public static final int DOOR_NAME_LEN = 32;
	public static final int STRESS_PASSWORD_LEN = 8;
	public static final int SUPER_PASSWORD_LEN = 8;
	public static final int UNLOCK_PASSWORD_LEN = 8;
	public static final int CARD_READER_DESCRIPTION = 32;
	public static final int MAX_DOOR_NUM_256 = 256;
	public static final int MAX_CASE_SENSOR_NUM = 8;
	public static final int MAX_CARD_READER_NUM = 64;
	public static final int MAX_CARD_READER_NUM_512 = 512;
	public static final int MAX_ALARMHOST_ALARMOUT_NUM = 512;
	public static final int MAX_ALARMHOST_ALARMIN_NUM = 512;
	public static final int ALARMHOST_DETECTOR_SERIAL_LEN = 9;

	public static final int PICTURE_NAME_LEN = 64;
	public static final int MAX_FACE_PIC_NUM = 30;
	public static final int CARDNUM_LEN_V30 = 40;
	public static final int MAX_ITC_LANE_NUM = 6;
	public static final int MAX_CHJC_NUM = 3;
	public static final int MAX_IOOUT_NUM = 4;
	public static final int MAX_LANEAREA_NUM = 2;
	public static final int MAX_INTERVAL_NUM = 4;
	public static final int ITC_MAX_POLYGON_POINT_NUM = 20;
	public static final int MAX_OVERLAP_ITEM_NUM = 50;
	public static final int MAX_STRINGNUM_V30 = 8;
	public static final int NET_DVR_FILE_SUCCESS = 1000;
	public static final int NET_DVR_FILE_NOFIND = 1001;
	public static final int NET_DVR_ISFINDING = 1002;
	public static final int NET_DVR_NOMOREFILE  = 1003;
	public static final int NET_DVR_FILE_EXCEPTION = 1004;

	public static class NET_DVR_TIME_V30 extends Structure{
		public short	wYear;
		public byte		byMonth;
		public byte		byDay;
		public byte		byHour;
		public byte		byMinute;
		public byte		bySecond;
		public byte		byRes;
		public short    wMilliSec;
		public byte[]	byRes1 = new byte[2];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("wYear", "byMonth", "byDay", "byHour","byMinute", "bySecond","byRes", "wMilliSec", "byRes1");
		}
	}

	public static class NET_DVR_IPADDR extends Structure {
		public byte[] sIpV4 = new byte[16];
		public byte[] byRes = new byte[128];

		public String toString() {
			return "NET_DVR_IPADDR.sIpV4: " + new String(sIpV4) + "\n"
					+ "NET_DVR_IPADDR.byRes: " + new String(byRes) + "\n";
		}
		@Override
		protected List getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("sIpV4", "byRes");
		}
	}

	public static class NET_VCA_POINT extends Structure{
		public  float  fX;
		public float  fY;
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("fX", "fY");
		}
	}

	public static class NET_VCA_LINE extends Structure{
		public NET_VCA_POINT   struStart = new NET_VCA_POINT();
		public NET_VCA_POINT   struEnd = new NET_VCA_POINT();
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struStart", "struEnd");
		}
	}

	public static class NET_VCA_POLYGON extends Structure {

		public int dwPointNum;
		public NET_VCA_POINT[] struPos = (NET_VCA_POINT[]) new NET_VCA_POINT().toArray(10);
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwPointNum", "struPos");
		}
	}


	public static class NET_DVR_MULTI_ALARMIN_COND extends Structure {
		public int	dwSize;
		public int[] iZoneNo = new int[MAX_MAX_ALARMIN_NUM];	//zone numner start with 0,invalid < 0
		public byte[] byRes = new byte[256];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "iZoneNo","byRes");
		}
	}

	public static class NET_DVR_SINGLE_ALARMIN_PARAM extends Structure {
		public int dwSize;
		public short wZoneNo;		//readonly
		public byte	byJointSubSystem; //readonly
		public byte byType;			//type 0:real time ,1-24 hours,2-delay ,3-innter，4-key  5-fire alarm 6-boundary 7-24 hours without sound  8-24 hours support ，9-24 hours shake 0xff-no
		public byte[] byName = new byte[NAME_LEN];
		public short wDetectorType;	// DETECTOR_TYPE
		public short wInDelay;
		public short wOutDelay;
		public byte byAlarmType;
		public byte byZoneSignalType;
		public byte[] byDetectorSerialNo = new byte[ALARMHOST_DETECTOR_SERIAL_LEN];
		public byte byDisableDetectorTypeCfg;
		public byte[] byRes2 = new byte[118];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "wZoneNo", "byJointSubSystem", "byType",
					"byName", "wDetectorType", "wInDelay", "wOutDelay", "byAlarmType",
					"byZoneSignalType", "byDetectorSerialNo", "byDisableDetectorTypeCfg", "byRes2");
		}
	}

	public static class NET_DVR_ALARMIN_PARAM_LIST extends Structure {
		public int dwSize;
		public NET_DVR_SINGLE_ALARMIN_PARAM[] struSingleAlarmInParam = (NET_DVR_SINGLE_ALARMIN_PARAM[]) new NET_DVR_SINGLE_ALARMIN_PARAM().toArray(MAX_MAX_ALARMIN_NUM);
		public byte[] byRes = new byte[128];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "struSingleAlarmInParam", "byRes");
		}
	}

	public static class NET_DVR_STD_CONFIG extends Structure {
		public Pointer lpCondBuffer;
		public int dwCondSize;
		public Pointer lpInBuffer;
		public int dwInSize;
		public Pointer lpOutBuffer;
		public int dwOutSize;
		public Pointer lpStatusBuffer;
		public int dwStatusSize;
		public Pointer lpXmlBuffer;
		public int dwXmlSize;
		public byte byDataType;
		public byte[] byRes = new byte[23];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("lpCondBuffer", "dwCondSize",
					"lpInBuffer", "dwInSize", "lpOutBuffer", "dwOutSize",
					"lpStatusBuffer", "dwStatusSize", "lpXmlBuffer",
					"dwXmlSize", "byDataType", "byRes");
		}
	}

	public static class NET_DVR_STD_ABILITY extends Structure {
		public Pointer lpCondBuffer;
		public int dwCondSize;
		public Pointer lpOutBuffer;
		public int dwOutSize;
		public Pointer lpStatusBuffer;
		public int dwStatusSize;
		public int dwRetSize;
		public byte[] byRes = new byte[32];
		@Override
		protected List getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("lpCondBuffer", "dwCondSize",
					"lpOutBuffer", "dwOutSize", "lpStatusBuffer",
					"dwStatusSize", "dwRetSize", "byRes");
		}
	}

	public static class NET_VCA_RECT extends Structure {
		public float fX;
		public float fY;
		public float fWidth;
		public float fHeight;
		@Override
		protected List getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays
					.asList("fX", "fY", "fWidth", "fHeight");
		}
	}

	public static class NET_DVR_ALARMINFO extends Structure {
		public int dwAlarmType;
		public int dwAlarmInputNumber;
		public int[] dwAlarmOutputNumber = new int[MAX_ALARMOUT];
		public int[] dwAlarmRelateChannel = new int[MAX_CHANNUM];
		public int[] dwChannel = new int[MAX_CHANNUM];
		public int[] dwDiskNumber = new int[MAX_DISKNUM];
		@Override
		protected List getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwAlarmType",
					"dwAlarmInputNumber", "dwAlarmOutputNumber",
					"dwAlarmRelateChannel", "dwChannel", "dwDiskNumber");
		}
	}

	public static class NET_DVR_TIME extends Structure {
		public int dwYear;
		public int dwMonth;
		public int dwDay;
		public int dwHour;
		public int dwMinute;
		public int dwSecond;
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwYear", "dwMonth", "dwDay",
					"dwHour", "dwMinute", "dwSecond");
		}
	}


	//public static class NET_DVR_NTPPARA extends Structure {
	//	public byte[] sNTPServer = new byte[64];           /* Domain Name or IP addr of NTP server */
	//	public short wInterval;		                       /* adjust time interval(hours) */
	//	public byte byEnableNTP;                           /* enable NTP client 0-no，1-yes*/
	//	public byte cTimeDifferenceH;                      /* UTC -12 ... +13 */
	//	public byte cTimeDifferenceM;                      /* UTC minutes 0, 30, 45*/
	//	public byte res1;
	//	public short wNtpPort;                             /* ntp server port 9000 default 123*/
	//	public byte[] res2 = new byte[8];
	//	@Override
	//	protected List<String> getFieldOrder() {
	//		// TODO Auto-generated method stub
	//		return Arrays.asList("sNTPServer", "wInterval", "byEnableNTP",
	//				"cTimeDifferenceH", "cTimeDifferenceM", "res1", "wNtpPort", "res2");
	//	}
	//}

	public static class NET_DVR_SIMPLE_DAYTIME extends Structure {
		public byte byHour;
		public byte byMinute;
		public byte bySecond;
		public byte byRes;
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byHour", "byMinute", "bySecond",
					"byRes");
		}
	}

	public static class NET_DVR_TIME_SEGMENT extends Structure {
		public NET_DVR_SIMPLE_DAYTIME struBeginTime = new NET_DVR_SIMPLE_DAYTIME();
		public NET_DVR_SIMPLE_DAYTIME struEndTime = new NET_DVR_SIMPLE_DAYTIME();
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struBeginTime", "struEndTime");
		}
	}

	public static class NET_DVR_SINGLE_PLAN_SEGMENT extends Structure {
		public byte byEnable;
		public byte byDoorStatus; //0-invalid，1-dormant，2-alawys open，3-alawys closed
		public byte byVerifyMode; //0-invalid，1-dormant，2-card+password 3-card ，4-card or password，5-fingerprint，6-fingerprint and password，7-fingerprint or card，8-fingerprint and card，9-fingerprint and card and password
		public byte[] byRes = new byte[5];
		public NET_DVR_TIME_SEGMENT struTimeSegment = new NET_DVR_TIME_SEGMENT();
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byEnable", "byDoorStatus", "byVerifyMode", "byRes",
					"struTimeSegment");
		}
	}

	public static class NET_DVR_DATE extends Structure{
		public short wYear;
		public byte byMonth;
		public byte byDay;
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("wYear", "byMonth", "byDay");
		}
	}

	//2-dimen array
	public static class arrayStruPlanCfg extends Structure {
		public NET_DVR_SINGLE_PLAN_SEGMENT[] struDaysPlanCfg = (NET_DVR_SINGLE_PLAN_SEGMENT[])new NET_DVR_SINGLE_PLAN_SEGMENT().toArray(MAX_TIMESEGMENT_V30);
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struDaysPlanCfg");
		}
	}

	public static class NET_DVR_WEEK_PLAN_CFG extends Structure {
		public int dwSize;
		public byte byEnable;  //0-no,1-enabled
		public byte[] byRes1 = new byte[3];
		public arrayStruPlanCfg[] struPlanCfg = (arrayStruPlanCfg[])new arrayStruPlanCfg().toArray(MAX_DAYS);
		public byte[] byRes2 = new byte[16];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byEnable", "byRes1", "struPlanCfg",
					"byRes2");
		}
	}

	public static class NET_DVR_WEEK_PLAN_COND extends Structure {
		public int dwSize;
		public int dwWeekPlanNumber;     //no.
		public short wLocalControllerID; //in [1,64]
		public byte[] byRes = new byte[106];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwWeekPlanNumber", "wLocalControllerID", "byRes");
		}
	}

	public static class NET_DVR_HOLIDAY_PLAN_CFG extends Structure {
		public int dwSize;
		public byte byEnable; //0-no,1-enabled
		public byte[] byRes1 = new byte[3];
		public NET_DVR_DATE struBeginDate = new NET_DVR_DATE();
		public NET_DVR_DATE struEndDate = new NET_DVR_DATE();
		public NET_DVR_SINGLE_PLAN_SEGMENT[] struPlanCfg = (NET_DVR_SINGLE_PLAN_SEGMENT[])new NET_DVR_SINGLE_PLAN_SEGMENT().toArray(MAX_TIMESEGMENT_V30);
		public byte[] byRes2 = new byte[16];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byEnable", "byRes1", "struBeginDate",
					"struEndDate", "struPlanCfg", "byRes2");
		}
	}

	public static class NET_DVR_HOLIDAY_PLAN_COND extends Structure {
		public int dwSize;
		public int dwHolidayPlanNumber;
		public short wLocalControllerID; //[1,64]
		public byte[] byRes = new byte[106];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwHolidayPlanNumber", "wLocalControllerID", "byRes");
		}
	}

	public static class NET_DVR_HOLIDAY_GROUP_CFG extends Structure {
		public int dwSize;
		public byte byEnable; //0-no,1-enabled
		public byte[] byRes1 = new byte[3];
		public byte[] byGroupName = new byte[HOLIDAY_GROUP_NAME_LEN];
		public int[] dwHolidayPlanNo = new int[MAX_HOLIDAY_PLAN_NUM]; //0 invalid
		public byte[] byRes2 = new byte[32];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byEnable", "byRes1", "byGroupName",
					"dwHolidayPlanNo", "byRes2");
		}
	}

	public static class NET_DVR_HOLIDAY_GROUP_COND extends Structure {
		public int dwSize;
		public int dwHolidayGroupNumber;
		public short wLocalControllerID; //[1,64]
		public byte[] byRes = new byte[106];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwHolidayGroupNumber", "wLocalControllerID", "byRes");
		}
	}

	public static class NET_DVR_PLAN_TEMPLATE extends Structure {
		public int dwSize;
		public byte byEnable;
		public byte[] byRes1= new byte[3];
		public byte[] byTemplateName = new byte[TEMPLATE_NAME_LEN];
		public int dwWeekPlanNo; //周计划编号，0为无效
		public int[] dwHolidayGroupNo = new int[MAX_HOLIDAY_GROUP_NUM];
		public byte[] byRes2 = new byte[32];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byEnable", "byRes1", "byTemplateName",
					"dwWeekPlanNo", "dwHolidayGroupNo", "byRes2");
		}
	}

	public static class NET_DVR_PLAN_TEMPLATE_COND extends Structure {
		public int dwSize;
		public int dwPlanTemplateNumber;
		public short wLocalControllerID; //[1,64]
		public byte[] byRes = new byte[106];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwPlanTemplateNumber", "wLocalControllerID", "byRes");
		}
	}

	public static class NET_DVR_DEVICECFG_V40 extends Structure {
		public int dwSize;
		public byte[] sDVRName = new byte[NAME_LEN];     //DVR name
		public int dwDVRID;				//DVR ID,//V1.4(0-99), V1.5(0-255)
		public int dwRecycleRecord;		//1-yes 0-no
		//readonly
		public byte[] sSerialNumber = new byte[SERIALNO_LEN];
		public int dwSoftwareVersion;		//high 16 bit major,minor low 16 bit
		public int dwSoftwareBuildDate;		//0xYYYYMMDD
		public int dwDSPSoftwareVersion;    //DSP high 16 bit major,minor low 16 bit
		public int dwDSPSoftwareBuildDate;  //DSP 0xYYYYMMDD
		public int dwPanelVersion;		    ////high 16 bit major,minor low 16 bit
		public int dwHardwareVersion;	    ////16 MSBmajor,minor LSB 16
		public byte byAlarmInPortNum;
		public byte byAlarmOutPortNum;
		public byte byRS232Num;
		public byte byRS485Num;
		public byte byNetworkPortNum;
		public byte byDiskCtrlNum;
		public byte byDiskNum;
		public byte byDVRType;				//DVR type, 1:DVR 2:ATM DVR 3:DVS ......
		public byte byChanNum;
		public byte byStartChan;			//DVS-1,DVR - 1
		public byte byDecordChans;
		public byte byVGANum;				//VGA
		public byte byUSBNum;				//USB
		public byte byAuxoutNum;
		public byte byAudioNum;
		public byte byIPChanNum;			//low 8，high 8 see byHighIPChanNum
		public byte byZeroChanNum;
		public byte bySupport;              //0-not support，1-support，
		//bySupport & 0x1, intelligent search
		//bySupport & 0x2, backup
		//bySupport & 0x4, compressinfo config
		//bySupport & 0x8, multi netcard
		//bySupport & 0x10, SADP
		//bySupport & 0x20, Raid card
		//bySupport & 0x40, IPSAN search
		//bySupport & 0x80, rtp over rtsp
		public byte byEsataUseage;		//Esata ，0-backup，1-record
		public byte byIPCPlug;			//0-close ，1-open
		public byte byStorageMode;		//0-HDD group,1-quota, 2-frame extract
		public byte bySupport1;		 //0-not support，1-support，
		//bySupport1 & 0x1, snmp v30
		//bySupport1 & 0x2, playback or download
		//bySupport1 & 0x4, alarm priority
		//bySupport1 & 0x8, set alarm time extend
		//bySupport1 & 0x10, multi HDD（over 33）
		//bySupport1 & 0x20, rtsp over http
		public short wDevType;
		public byte[] byDevTypeName = new byte[DEV_TYPE_NAME_LEN];
		public byte bySupport2;
		//bySupport2 & 0x1, OSD extra
		public byte byAnalogAlarmInPortNum;
		public byte byStartAlarmInNo;
		public byte byStartAlarmOutNo;
		public byte byStartIPAlarmInNo;
		public byte byStartIPAlarmOutNo;
		public byte byHighIPChanNum;
		public byte[] byRes2= new byte[9];			//reserved
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "sDVRName", "dwDVRID", "dwRecycleRecord",
					"sSerialNumber", "dwSoftwareVersion", "dwSoftwareBuildDate", "dwDSPSoftwareVersion",
					"dwDSPSoftwareBuildDate", "dwPanelVersion", "dwHardwareVersion", "byAlarmInPortNum",
					"byAlarmOutPortNum", "byRS232Num", "byRS485Num", "byNetworkPortNum", "byDiskCtrlNum",
					"byDiskNum", "byDVRType", "byChanNum", "byStartChan", "byDecordChans", "byVGANum",
					"byUSBNum", "byAuxoutNum", "byAudioNum", "byIPChanNum", "byZeroChanNum", "bySupport",
					"byEsataUseage", "byIPCPlug", "byStorageMode0", "bySupport1", "wDevType", "byDevTypeName",
					"bySupport2", "byAnalogAlarmInPortNum", "byStartAlarmInNo", "byStartAlarmOutNo",
					"byStartIPAlarmInNo", "byStartIPAlarmOutNo", "byHighIPChanNum", "byRes2");
		}
	}

	public static class NET_DVR_DOOR_CFG extends Structure {
		public int dwSize;
		public byte[] byDoorName = new byte[DOOR_NAME_LEN];
		public byte byMagneticType;
		public byte byOpenButtonType;
		public byte byOpenDuration;
		public byte byDisabledOpenDuration;
		public byte byMagneticAlarmTimeout;
		public byte byEnableDoorLock;
		public byte byEnableLeaderCard;
		public byte byLeaderCardMode;
		public int dwLeaderCardOpenDuration;
		public byte[] byStressPassword = new byte[STRESS_PASSWORD_LEN];
		public byte[] bySuperPassword = new byte[SUPER_PASSWORD_LEN];
		public byte[] byUnlockPassword = new byte[UNLOCK_PASSWORD_LEN];
		public byte byUseLocalController;
		public byte byRes1;
		public short wLocalControllerID;
		public short wLocalControllerDoorNumber;
		public short wLocalControllerStatus;
		public byte byLockInputCheck;
		public byte byLockInputType;
		public byte byDoorTerminalMode;
		public byte byOpenButton;
		public byte byLadderControlDelayTime;
		public byte[] byRes2 = new byte[43];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byDoorName", "byMagneticType", "byOpenButtonType",
					"byOpenDuration", "byDisabledOpenDuration", "byMagneticAlarmTimeout", "byEnableDoorLock",
					"byEnableLeaderCard", "byLeaderCardMode", "dwLeaderCardOpenDuration", "byStressPassword",
					"bySuperPassword", "byUnlockPassword", "byUseLocalController", "byRes1", "wLocalControllerID",
					"wLocalControllerDoorNumber", "wLocalControllerStatus", "byLockInputCheck", "byLockInputType",
					"byDoorTerminalMode", "byOpenButton", "byLadderControlDelayTime", "byRes2");
		}
	}

	public static class NET_DVR_CARD_READER_CFG_V50 extends Structure {
		public int dwSize;
		public byte byEnable;
		public byte byCardReaderType; //，1-DS-K110XM/MK/C/CK，2-DS-K192AM/AMP，3-DS-K192BM/BMP，4-DS-K182AM/AMP，5-DS-K182BM/BMP，6-DS-K182AMF/ACF，7-韦根或485不在线，8- DS-K1101M/MK，9- DS-K1101C/CK，10- DS-K1102M/MK/M-A，11- DS-K1102C/CK，12- DS-K1103M/MK，13- DS-K1103C/CK，14- DS-K1104M/MK，15- DS-K1104C/CK，16- DS-K1102S/SK/S-A，17- DS-K1102G/GK，18- DS-K1100S-B，19- DS-K1102EM/EMK，20- DS-K1102E/EK，21- DS-K1200EF，22- DS-K1200MF，23- DS-K1200CF，24- DS-K1300EF，25- DS-K1300MF，26- DS-K1300CF，27- DS-K1105E，28- DS-K1105M，29- DS-K1105C，30- DS-K182AMF，31- DS-K196AMF，32-DS-K194AMP，33-DS-K1T200EF/EF-C/MF/MF-C/CF/CF-C,34-DS-K1T300EF/EF-C/MF/MF-C/CF/CF-C，35-DS-K1T105E/E-C/M/M-C/C/C-C,36-DS-K1T803F/F-M/F-S/F-E,37-DS-K1A801F/F-M/F-S/F-E,38-DS-K1107M/MK,39-DS-K1107E/EK,40-DS-K1107S/SK,41-DS-K1108M/MK,42-DS-K1108E/EK,43-DS-K1108S/SK,44-DS-K1200F,45-DS-K1S110-I,46-DS-K1T200M-PG/PGC,47-DS-K1T200M-PZ/PZC,48-DS-K1109H
		public byte byOkLedPolarity;
		public byte byErrorLedPolarity;
		public byte byBuzzerPolarity;
		public byte bySwipeInterval;
		public byte byPressTimeout;
		public byte byEnableFailAlarm;
		public byte byMaxReadCardFailNum;
		public byte byEnableTamperCheck;
		public byte byOfflineCheckTime;
		public byte byFingerPrintCheckLevel;
		public byte byUseLocalController;
		public byte byRes1;
		public short wLocalControllerID;
		public short wLocalControllerReaderID;
		public short wCardReaderChannel;
		public byte byFingerPrintImageQuality;
		public byte byFingerPrintContrastTimeOut;
		public byte byFingerPrintRecogizeInterval;
		public byte byFingerPrintMatchFastMode;
		public byte byFingerPrintModuleSensitive;
		public byte byFingerPrintModuleLightCondition;
		public byte byFaceMatchThresholdN;
		public byte byFaceQuality;
		public byte byFaceRecogizeTimeOut;
		public byte byFaceRecogizeInterval;
		public short wCardReaderFunction;
		public byte[] byCardReaderDescription = new byte[CARD_READER_DESCRIPTION];
		public short wFaceImageSensitometry;
		public byte byLivingBodyDetect;
		public byte byFaceMatchThreshold1;
		public byte[] byRes = new byte[256];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byEnable", "byCardReaderType", "byOkLedPolarity",
					"byErrorLedPolarity", "byBuzzerPolarity", "bySwipeInterval", "byPressTimeout",
					"byEnableFailAlarm", "byMaxReadCardFailNum", "byEnableTamperCheck", "byOfflineCheckTime",
					"byFingerPrintCheckLevel", "byUseLocalController", "byRes1", "wLocalControllerID", "wLocalControllerReaderID",
					"wCardReaderChannel", "byFingerPrintImageQuality", "byFingerPrintContrastTimeOut", "byFingerPrintRecogizeInterval", "byFingerPrintMatchFastMode",
					"byFingerPrintModuleSensitive", "byFingerPrintModuleLightCondition", "byFaceMatchThresholdN",
					"byFaceQuality", "byFaceRecogizeTimeOut", "byFaceRecogizeInterval", "wCardReaderFunction",
					"byCardReaderDescription", "wFaceImageSensitometry", "byLivingBodyDetect", "byFaceMatchThreshold1", "byRes");
		}
	}

	public static class NET_DVR_ACS_WORK_STATUS extends Structure
	{
		public int dwSize;
		public byte[]	byDoorLockStatus = new byte[MAX_DOOR_NUM];
		public byte[]	byDoorStatus = new byte[MAX_DOOR_NUM];
		public byte[]	byMagneticStatus = new byte[MAX_DOOR_NUM];
		public byte[]	byCaseStatus = new byte[MAX_CASE_SENSOR_NUM];
		public short wBatteryVoltage;
		public byte byBatteryLowVoltage;
		public byte byPowerSupplyStatus;
		public byte byMultiDoorInterlockStatus;
		public byte byAntiSneakStatus;
		public byte byHostAntiDismantleStatus;
		public byte byIndicatorLightStatus;
		public byte[]	byCardReaderOnlineStatus = new byte[MAX_CARD_READER_NUM];
		public byte[]	byCardReaderAntiDismantleStatus = new byte[MAX_CARD_READER_NUM];
		public byte[]	byCardReaderVerifyMode = new byte[MAX_CARD_READER_NUM];
		public byte[]	bySetupAlarmStatus = new byte[MAX_ALARMHOST_ALARMIN_NUM];
		public byte[]	byAlarmInStatus = new byte[MAX_ALARMHOST_ALARMIN_NUM];
		public byte[]	byAlarmOutStatus = new byte[MAX_ALARMHOST_ALARMOUT_NUM];
		public int dwCardNum;
		public byte[]	byRes2 = new byte[32];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize","byDoorLockStatus","byDoorStatus","byMagneticStatus","byCaseStatus","wBatteryVoltage","byBatteryLowVoltage",
					"byPowerSupplyStatus","byMultiDoorInterlockStatus","byAntiSneakStatus","byHostAntiDismantleStatus","byIndicatorLightStatus",
					"byCardReaderOnlineStatus","byCardReaderAntiDismantleStatus","byCardReaderVerifyMode","bySetupAlarmStatus","byAlarmInStatus",
					"byAlarmOutStatus","dwCardNum","byRes2");
		}
	}

	public static class NET_DVR_ACS_WORK_STATUS_V50 extends Structure {
		public int dwSize;
		public byte[] byDoorLockStatus = new byte[MAX_DOOR_NUM_256];
		public byte[] byDoorStatus = new byte[MAX_DOOR_NUM_256];
		public byte[] byMagneticStatus = new byte[MAX_DOOR_NUM_256];
		public byte[] byCaseStatus = new byte[MAX_CASE_SENSOR_NUM];
		public short wBatteryVoltage;
		public byte byBatteryLowVoltage;
		public byte byPowerSupplyStatus;
		public byte byMultiDoorInterlockStatus;
		public byte byAntiSneakStatus;
		public byte byHostAntiDismantleStatus;
		public byte byIndicatorLightStatus;
		public byte[] byCardReaderOnlineStatus = new byte[MAX_CARD_READER_NUM_512];
		public byte[] byCardReaderAntiDismantleStatus = new byte[MAX_CARD_READER_NUM_512];
		public byte[] byCardReaderVerifyMode = new byte[MAX_CARD_READER_NUM_512];
		public byte[] bySetupAlarmStatus = new byte[MAX_ALARMHOST_ALARMIN_NUM];
		public byte[] byAlarmInStatus = new byte[MAX_ALARMHOST_ALARMIN_NUM];
		public byte[] byAlarmOutStatus = new byte[MAX_ALARMHOST_ALARMOUT_NUM];
		public int dwCardNum;
		public byte byFireAlarmStatus;
		public byte[] byRes2 = new byte[123];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byDoorLockStatus", "byDoorStatus", "byMagneticStatus",
					"byCaseStatus", "wBatteryVoltage", "byBatteryLowVoltage", "byPowerSupplyStatus", "byMultiDoorInterlockStatus",
					"byAntiSneakStatus", "byHostAntiDismantleStatus", "byIndicatorLightStatus", "byCardReaderOnlineStatus",
					"byCardReaderAntiDismantleStatus", "byCardReaderVerifyMode", "bySetupAlarmStatus", "byAlarmInStatus", "byAlarmOutStatus",
					"dwCardNum", "byFireAlarmStatus", "byRes2");
		}
	}

	public static class NET_DVR_ACS_PARAM_TYPE extends Structure {
		public int dwSize;
		public int dwParamType;
		public byte[] byRes = new byte[32];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwParamType", "byRes");
		}
	}

	public static class NET_DVR_WIFI_WORKMODE extends Structure {
		public int   dwSize;
		public int   dwNetworkInterfaceMode;
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwNetworkInterfaceMode");
		}
	}

	public static class NET_DVR_COMPLETE_RESTORE_INFO extends Structure {
		public int   dwSize ;
		public int   dwChannel;
		public byte[]    byRes = new byte[64];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwChannel", "byRes");
		}
	}

	public static class NET_DVR_XML_CONFIG_INPUT extends Structure
	{
		public int 		dwSize;
		public Pointer	lpRequestUrl;
		public int		dwRequestUrlLen;
		public Pointer	lpInBuffer;
		public int		dwInBufferSize;
		public int		dwRecvTimeOut;
		public byte[]	byRes = new byte[32];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "lpRequestUrl", "dwRequestUrlLen", "lpInBuffer", "dwInBufferSize",
					"dwRecvTimeOut", "byRes");
		}
	}

	public static class NET_DVR_XML_CONFIG_OUTPUT extends Structure {
		public int dwSize;
		public Pointer lpOutBuffer;
		public int dwOutBufferSize;
		public int dwReturnedXMLSize;
		public Pointer lpStatusBuffer;
		public int dwStatusSize;
		public byte[] byRes = new byte[32];
		@Override
		protected List getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "lpOutBuffer",
					"dwOutBufferSize", "dwReturnedXMLSize", "lpStatusBuffer",
					"dwStatusSize", "byRes");
		}
	}

	public static class NET_DVR_CALL_ROOM_CFG extends Structure {
		public int dwSize;
		public short nFloorNumber;
		public short wRoomNumber;
		public byte byManageCenter;
		public byte[] byRes = new byte[127];
		@Override
		protected List getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "nFloorNumber", "wRoomNumber", "byManageCenter", "byRes");
		}
	}

	public static class NET_DVR_ALARMER extends Structure {
		public byte byUserIDValid;
		public byte bySerialValid;
		public byte byVersionValid;
		public byte byDeviceNameValid;
		public byte byMacAddrValid;
		public byte byLinkPortValid;
		public byte byDeviceIPValid;
		public byte bySocketIPValid;
		public int lUserID;
		public byte[] sSerialNumber = new byte[SERIALNO_LEN];
		public int dwDeviceVersion;
		public byte[] sDeviceName = new byte[NAME_LEN];
		public byte[] byMacAddr = new byte[MACADDR_LEN];
		public short wLinkPort;
		public byte[] sDeviceIP = new byte[128];
		public byte[] sSocketIP = new byte[128];
		public byte byIpProtocol;
		public byte[] byRes2 = new byte[11];
		@Override
		protected List getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byUserIDValid",
					"bySerialValid", "byVersionValid", "byDeviceNameValid",
					"byMacAddrValid", "byLinkPortValid", "byDeviceIPValid",
					"bySocketIPValid", "lUserID", "sSerialNumber",
					"dwDeviceVersion", "sDeviceName", "byMacAddr", "wLinkPort",
					"sDeviceIP", "sSocketIP", "byIpProtocol", "byRes2");
		}
	}

	public static class NET_DVR_ALARMINFO_V30 extends Structure {
		public int dwAlarmType;
		public int dwAlarmInputNumber;
		public byte[] byAlarmOutputNumber = new byte[MAX_ALARMOUT_V30];
		public byte[] byAlarmRelateChannel = new byte[MAX_CHANNUM_V30];
		public byte[] byChannel = new byte[MAX_CHANNUM_V30];
		public byte[] byDiskNumber = new byte[MAX_DISKNUM_V30];

		public NET_DVR_ALARMINFO_V30(Pointer p) {
			super(p);
		}
		@Override
		protected List getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwAlarmType",
					"dwAlarmInputNumber", "byAlarmOutputNumber",
					"byAlarmRelateChannel", "byChannel", "byDiskNumber");
		}
	}

	public static class struIOAlarm extends Structure{
		public int dwAlarmInputNo;
		public int dwTrigerAlarmOutNum;
		public int dwTrigerRecordChanNum;
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwAlarmInputNo","dwTrigerAlarmOutNum", "dwTrigerRecordChanNum");
		}
	}

	public static class NET_DVR_TIME_EX extends Structure{
		public short wYear;
		public byte byMonth;
		public byte byDay;
		public byte byHour;
		public byte byMinute;
		public byte bySecond;
		public byte byRes;
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("wYear","byMonth", "byDay", "byHour","byMinute", "bySecond", "byRes");
		}
	}

	public static class NET_VCA_DEV_INFO extends Structure{
		public NET_DVR_IPADDR struDevIP = new NET_DVR_IPADDR();
		public short wPort;
		public byte byChannel;
		public byte byIvmsChannel;
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struDevIP", "wPort", "byChannel", "byIvmsChannel");
		}
	}

	public static class  struRecordingHost extends Structure{
		public byte bySubAlarmType;
		public byte[] byRes1 = new byte[3];
		public NET_DVR_TIME_EX struRecordEndTime = new NET_DVR_TIME_EX();
		public byte[] byRes = new byte[116];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("bySubAlarmType", "byRes1", "struRecordEndTime", "byRes");
		}
	}

	public static class struAlarmHardDisk extends Structure{
		public int dwAlarmHardDiskNum;

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwAlarmHardDiskNum");
		}
	}

	public static class struAlarmChannel extends Structure{
		public int dwAlarmChanNum;

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwAlarmChanNum");
		}
	}

	public static class uStruAlarm extends Union
	{
		public byte[] byUnionLen = new byte[128];
		public struIOAlarm struioAlarm = new struIOAlarm();
		public struAlarmHardDisk strualarmHardDisk = new struAlarmHardDisk();
		public struAlarmChannel sstrualarmChannel = new struAlarmChannel();
		public struRecordingHost strurecordingHost = new struRecordingHost();
	}

	public static class NET_DVR_ALRAM_FIXED_HEADER extends Structure{
		public int                       dwAlarmType;
		public NET_DVR_TIME_EX             struAlarmTime = new NET_DVR_TIME_EX();
		public uStruAlarm ustruAlarm = new uStruAlarm();
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwAlarmType", "struAlarmTime", "ustruAlarm");
		}
	}

	public static class NET_DVR_ALARMINFO_V40 extends Structure {
		public NET_DVR_ALRAM_FIXED_HEADER struAlarmFixedHeader = new NET_DVR_ALRAM_FIXED_HEADER();
		public Pointer pAlarmData;
		public NET_DVR_ALARMINFO_V40(Pointer p){
			super(p);
		}
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struAlarmFixedHeader", "pAlarmData");
		}
	}

	public static class NET_DVR_PLATE_INFO extends Structure{
		public byte byPlateType;
		public byte byColor;
		public byte byBright;
		public byte byLicenseLen;
		public byte byEntireBelieve;
		public byte byRegion;
		public byte byCountry;
		public byte[] byRes = new byte[33];
		public NET_VCA_RECT struPlateRect = new NET_VCA_RECT();
		public byte[] sLicense = new byte[MAX_LICENSE_LEN];
		public byte[] byBelieve = new byte[MAX_LICENSE_LEN];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byPlateType", "byColor", "byBright", "byLicenseLen", "byEntireBelieve", "byRegion",
					"byCountry", "byRes", "struPlateRect", "sLicense", "byBelieve");
		}

	}

	public static class NET_DVR_VEHICLE_INFO extends Structure{
		public int dwIndex;
		public byte byVehicleType;
		public byte byColorDepth;
		public byte byColor;
		public byte byRes1;
		public short wSpeed;
		public short wLength;
		public byte byIllegalType;
		public byte byVehicleLogoRecog;
		public byte byVehicleSubLogoRecog;
		public byte byVehicleModel;
		public byte[] byCustomInfo = new byte[16];
		public short wVehicleLogoRecog;
		public byte[] byRes3 = new byte[14];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwIndex", "byVehicleType", "byColorDepth", "byColor", "byRes1", "wSpeed",
					"wLength", "byIllegalType", "byVehicleLogoRecog", "byVehicleSubLogoRecog", "byVehicleModel",
					"byCustomInfo", "wVehicleLogoRecog", "byRes3");
		}
	}

	public static class NET_DVR_PLATE_RESULT extends Structure{
		public int dwSize;
		public byte byResultType;
		public byte byChanIndex;
		public short wAlarmRecordID;
		public int dwRelativeTime;
		public byte[] byAbsTime = new byte[32];
		public int dwPicLen;
		public int dwPicPlateLen;
		public int dwVideoLen;
		public byte byTrafficLight;
		public byte byPicNum;
		public byte byDriveChan;
		public byte byVehicleType;
		public int dwBinPicLen;
		public int dwCarPicLen;
		public int dwFarCarPicLen;
		public ByteByReference pBuffer3;
		public ByteByReference pBuffer4;
		public ByteByReference pBuffer5;
		public byte byRelaLaneDirectionType;
		public byte[] byRes3 = new byte[7];
		public NET_DVR_PLATE_INFO struPlateInfo = new NET_DVR_PLATE_INFO();
		public NET_DVR_VEHICLE_INFO struVehicleInfo = new NET_DVR_VEHICLE_INFO();
		public ByteByReference pBuffer1;
		public ByteByReference pBuffer2;

		public NET_DVR_PLATE_RESULT(Pointer p){
			super(p);
		}
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byResultType", "byChanIndex", "wAlarmRecordID", "dwRelativeTime", "byAbsTime",
					"dwPicLen", "dwPicPlateLen", "dwVideoLen", "byTrafficLight", "byPicNum", "byDriveChan", "byVehicleType",
					"dwBinPicLen", "dwCarPicLen", "dwFarCarPicLen", "pBuffer3", "pBuffer4", "pBuffer5", "byRelaLaneDirectionType",
					"byRes3", "struPlateInfo", "struVehicleInfo", "pBuffer1", "pBuffer2");
		}
	}

	public static class NET_ITS_PICTURE_INFO extends Structure{
		public int           dwDataLen;
		public byte          byType;
		public byte		     byDataType;
		public byte          byCloseUpType;
		public byte          byPicRecogMode;
		public int           dwRedLightTime;
		public byte[]        byAbsTime = new byte[32];
		public NET_VCA_RECT  struPlateRect;
		public NET_VCA_RECT  struPlateRecgRect;
		public ByteByReference      pBuffer;
		public int           dwUTCTime;
		public byte          byCompatibleAblity;
		public byte[]        byRes2 = new byte[7];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwDataLen", "byType", "byDataType", "byCloseUpType", "byPicRecogMode", "dwRedLightTime",
					"byAbsTime", "struPlateRect", "struPlateRecgRect", "pBuffer", "dwUTCTime", "byCompatibleAblity", "byRes2");
		}
	}

	public static class NET_ITS_PLATE_RESULT extends Structure{
		public int				   dwSize;
		public int      		   dwMatchNo;
		public byte				   byGroupNum;
		public byte                byPicNo;
		public byte                bySecondCam;
		public byte                byFeaturePicNo;
		public byte                byDriveChan;
		public byte                byVehicleType;
		public byte                byDetSceneID;
		public byte                byVehicleAttribute;
		public short               wIllegalType;
		public byte[]              byIllegalSubType = new byte[8];
		public byte                byPostPicNo;
		public byte                byChanIndex;
		public short               wSpeedLimit;
		public byte[]              byRes2 = new byte[2];
		public NET_DVR_PLATE_INFO  struPlateInfo = new NET_DVR_PLATE_INFO();
		public NET_DVR_VEHICLE_INFO     struVehicleInfo = new NET_DVR_VEHICLE_INFO();
		public byte[]              byMonitoringSiteID = new byte[48];
		public byte[]              byDeviceID = new byte[48];
		public byte                byDir;
		public byte                byDetectType;
		public byte                byRelaLaneDirectionType;
		public byte                byCarDirectionType;
		public int                 dwCustomIllegalType;
		public ByteByReference     pIllegalInfoBuf;
		public byte                byIllegalFromatType;
		public byte                byPendant;
		public byte                byDataAnalysis;
		public byte                byYellowLabelCar;
		public byte                byDangerousVehicles;
		public byte                byPilotSafebelt;
		public byte                byCopilotSafebelt;
		public byte                byPilotSunVisor;
		public byte                byCopilotSunVisor;
		public byte                byPilotCall;
		public byte                byBarrierGateCtrlType;
		public byte                byAlarmDataType;
		public NET_DVR_TIME_V30    struSnapFirstPicTime = new NET_DVR_TIME_V30();
		public int                 dwIllegalTime;
		public int                 dwPicNum;
		public NET_ITS_PICTURE_INFO[]     struPicInfo = (NET_ITS_PICTURE_INFO[])new NET_ITS_PICTURE_INFO().toArray(6);

		public NET_ITS_PLATE_RESULT(Pointer p){
			super(p);
		}
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwMatchNo", "byGroupNum", "byPicNo", "bySecondCam", "byFeaturePicNo","byDriveChan",
					"byVehicleType", "byDetSceneID", "byVehicleAttribute", "wIllegalType", "byIllegalSubType", "byPostPicNo",
					"byChanIndex", "wSpeedLimit", "byRes2", "struPlateInfo", "struVehicleInfo", "byMonitoringSiteID", "byDeviceID",
					"byDir", "byDetectType", "byRelaLaneDirectionType", "byCarDirectionType", "dwCustomIllegalType",
					"pIllegalInfoBuf","byIllegalFromatType", "byPendant", "byDataAnalysis", "byYellowLabelCar", "byDangerousVehicles", "byPilotSafebelt",
					"byCopilotSafebelt", "byPilotSunVisor", "byCopilotSunVisor", "byPilotCall", "byBarrierGateCtrlType", "byAlarmDataType",
					"struSnapFirstPicTime", "dwIllegalTime", "dwPicNum", "struPicInfo");
		}
	}

	public static class NET_VCA_TARGET_INFO extends Structure {
		public int          dwID;
		public NET_VCA_RECT struRect = new NET_VCA_RECT();
		public byte[]       byRes = new byte[4];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwID", "struRect", "byRes");
		}

	}

	public static class NET_VCA_TRAVERSE_PLANE extends Structure {
		public NET_VCA_LINE    struPlaneBottom = new NET_VCA_LINE();
		public int             dwCrossDirection;
		public byte            bySensitivity;
		public byte            byPlaneHeight;
		public byte            byDetectionTarget;
		public byte[]          byRes2 = new byte[37];

		public NET_VCA_TRAVERSE_PLANE(Pointer pointer){
			super(pointer);
		}
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struPlaneBottom", "dwCrossDirection", "bySensitivity", "byPlaneHeight", "byDetectionTarget", "byRes2");
		}
	}

	public static class NET_VCA_AREA extends Structure {
		public NET_VCA_POLYGON    struRegion = new NET_VCA_POLYGON();
		public byte               byDetectionTarget;
		public byte[]             byRes = new byte[7];

		public NET_VCA_AREA(Pointer pointer) {
			// TODO Auto-generated constructor stub
			super(pointer);
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "byDetectionTarget", "byRes");
		}
	}

	public static class NET_VCA_INTRUSION extends Structure {
		public NET_VCA_POLYGON    struRegion = new NET_VCA_POLYGON();
		public short              wDuration;
		public byte               bySensitivity;
		public byte               byRate;
		public byte               byDetectionTarget;
		public byte[]             byRes = new byte[3];

		public NET_VCA_INTRUSION(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "wDuration", "bySensitivity", "byRate", "byDetectionTarget", "byRes");
		}
	}

	public static class NET_VCA_LOITER extends Structure {
		public NET_VCA_POLYGON    struRegion = new NET_VCA_POLYGON();
		public short              wDuration;
		public byte[]             byRes = new byte[6];


		public NET_VCA_LOITER(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}


		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "wDuration", "byRes");
		}
	}

	public static class NET_VCA_TAKE_LEFT extends Structure {
		public NET_VCA_POLYGON    struRegion = new NET_VCA_POLYGON();
		public short              wDuration;
		public byte[]             byRes = new byte[6];


		public NET_VCA_TAKE_LEFT(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}


		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "wDuration", "byRes");
		}
	}

	public static class NET_VCA_PARKING extends Structure {
		public NET_VCA_POLYGON    struRegion = new NET_VCA_POLYGON();
		public short              wDuration;
		public byte[]             byRes = new byte[6];

		public NET_VCA_PARKING(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "wDuration", "byRes");
		}
	}

	public static class NET_VCA_RUN extends Structure {
		public NET_VCA_POLYGON    struRegion = new NET_VCA_POLYGON();
		public float              fRunDistance;
		public byte               bySensitivity;
		public byte               byMode;
		public byte               byDetectionTarget;
		public byte               byRes;

		public NET_VCA_RUN(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "fRunDistance", "bySensitivity", "byMode", "byDetectionTarget", "byRes");
		}
	}

	public static class NET_VCA_HIGH_DENSITY extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public float             fDensity;
		public byte              bySensitivity;
		public byte              byRes;
		public short             wDuration;

		public NET_VCA_HIGH_DENSITY(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "fDensity", "bySensitivity", "byRes", "wDuration");
		}
	}

	public static class NET_VCA_VIOLENT_MOTION extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public short             wDuration;
		public byte              bySensitivity;
		public byte              byMode;
		public byte[]            byRes = new byte[4];

		public NET_VCA_VIOLENT_MOTION(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "wDuration", "bySensitivity", "byMode", "byRes");
		}
	}

	public static class NET_VCA_REACH_HIGHT extends Structure {
		public NET_VCA_LINE     struVcaLine = new NET_VCA_LINE();
		public short            wDuration;
		public byte[]           byRes = new byte[6];

		public NET_VCA_REACH_HIGHT(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struVcaLine", "wDuration", "byRes");
		}
	}

	public static class NET_VCA_GET_UP extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public short             wDuration;
		public byte              byMode;
		public byte              bySensitivity;
		public byte[]            byRes = new byte[4];

		public NET_VCA_GET_UP(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "wDuration", "byMode", "bySensitivity", "byRes");
		}
	}

	public static class NET_VCA_LEFT extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public short             wDuration;
		public byte              bySensitivity;
		public byte[]            byRes = new byte[5];

		public NET_VCA_LEFT(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "wDuration", "bySensitivity", "byRes");
		}
	}

	public static class NET_VCA_TAKE extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public short             wDuration;
		public byte              bySensitivity;
		public byte[]            byRes = new byte[5];

		public NET_VCA_TAKE(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "wDuration", "bySensitivity", "byRes");
		}
	}

	public static class NET_VCA_HUMAN_ENTER extends Structure {
		public int[]            dwRes = new int[23];

		public NET_VCA_HUMAN_ENTER(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwRes");
		}
	}

	public static class NET_VCA_OVER_TIME extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public short             wDuration;
		public byte[]            byRes = new byte[6];

		public NET_VCA_OVER_TIME(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "wDuration", "byRes");
		}
	}

	public static class NET_VCA_STICK_UP extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public short             wDuration;
		public byte				 bySensitivity;
		public byte[]            byRes = new byte[5];

		public NET_VCA_STICK_UP(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "wDuration", "bySensitivity", "byRes");
		}
	}

	public static class NET_VCA_SCANNER extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public short             wDuration;
		public byte				 bySensitivity;
		public byte[]            byRes = new byte[5];

		public NET_VCA_SCANNER(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "wDuration", "bySensitivity", "byRes");
		}
	}

	public static class NET_VCA_LEAVE_POSITION extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public short             wLeaveDelay;
		public short             wStaticDelay;
		public byte              byMode;
		public byte              byPersonType;
		public byte[]            byRes = new byte[2];

		public NET_VCA_LEAVE_POSITION(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "wLeaveDelay", "wStaticDelay", "byMode", "byPersonType", "byRes");
		}
	}

	public static class NET_VCA_TRAIL extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public short             wRes;
		public byte				 bySensitivity;
		public byte[]            byRes = new byte[5];

		public NET_VCA_TRAIL(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "wRes", "bySensitivity", "byRes");
		}
	}

	public static class NET_VCA_FALL_DOWN extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public short             wDuration;
		public byte				 bySensitivity;
		public byte				 byHeightThreshold;
		public byte[]            byRes = new byte[4];

		public NET_VCA_FALL_DOWN(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "wDuration", "bySensitivity", "byHeightThreshold", "byRes");
		}
	}

	public static class NET_VCA_AUDIO_ABNORMAL extends Structure {
		public short    wDecibel;
		public byte     bySensitivity;
		public byte     byAudioMode;
		public byte     byEnable;
		public byte     byThreshold;
		public byte[]   byRes = new byte[54];

		public NET_VCA_AUDIO_ABNORMAL(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("wDecibel", "bySensitivity", "byAudioMode", "byEnable", "byThreshold", "byRes");
		}
	}

	public static class NET_VCA_ADV_REACH_HEIGHT extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public int				 dwCrossDirection;
		public byte[]            byRes = new byte[4];

		public NET_VCA_ADV_REACH_HEIGHT(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "dwCrossDirection", "byRes");
		}
	}

	public static class NET_VCA_TOILET_TARRY extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public short			 wDelay;
		public byte[]            byRes = new byte[6];

		public NET_VCA_TOILET_TARRY(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "wDelay", "byRes");
		}
	}

	public static class NET_VCA_YARD_TARRY extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public short			 wDelay;
		public byte[]            byRes = new byte[6];

		public NET_VCA_YARD_TARRY(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "wDelay", "byRes");
		}
	}

	public static class NET_VCA_ADV_TRAVERSE_PLANE extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public int               dwCrossDirection;
		public byte              bySensitivity;
		public byte[]            byRes = new byte[3];

		public NET_VCA_ADV_TRAVERSE_PLANE(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "dwCrossDirection", "bySensitivity", "byRes");
		}
	}

	public static class NET_VCA_STANDUP extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public byte              bySensitivity;
		public byte              byHeightThreshold;
		public short             wDuration;
		public byte[]            byRes = new byte[4];

		public NET_VCA_STANDUP(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "bySensitivity", "byHeightThreshold", "wDuration", "byRes");
		}
	}

	public static class NET_VCA_PEOPLENUM_CHANGE extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public byte              bySensitivity;
		public byte              byPeopleNumThreshold;
		public byte              byDetectMode;
		public byte              byNoneStateEffective;
		public short             wDuration;
		public byte[]            byRes = new byte[2];

		public NET_VCA_PEOPLENUM_CHANGE(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "bySensitivity", "byPeopleNumThreshold", "byDetectMode", "byNoneStateEffective", "wDuration", "byRes");
		}
	}

	public static class NET_VCA_SPACING_CHANGE extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public float             fSpacingThreshold;
		public byte              bySensitivity;
		public byte              byDetectMode;
		public short             wDuration;

		public NET_VCA_SPACING_CHANGE(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "fSpacingThreshold", "bySensitivity", "byDetectMode", "wDuration");
		}
	}

	public static class NET_VCA_RELATE_RULE_PARAM extends Structure {
		public byte    byRuleID;
		public byte    byRes;
		public short   wEventType;
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byRuleID", "byRes", "wEventType");
		}
	}

	public static class NET_VCA_COMBINED_RULE extends Structure {
		public byte                     byRuleSequence;
		public byte[]                   byRes = new byte[7];
		public int                      dwMinInterval;
		public int                      dwMaxInterval;
		public NET_VCA_RELATE_RULE_PARAM     struRule1Raram = new NET_VCA_RELATE_RULE_PARAM();
		public NET_VCA_RELATE_RULE_PARAM     struRule2Raram = new NET_VCA_RELATE_RULE_PARAM();
		public byte[]                   byRes1 = new byte[36];

		public NET_VCA_COMBINED_RULE(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byRuleSequence", "byRes", "dwMinInterval", "dwMaxInterval", "struRule1Raram", "struRule2Raram", "byRes1");
		}
	}

	public static class NET_VCA_SIT_QUIETLY extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public int               dwDuration;
		public byte[]			 byRes = new byte[4];

		public NET_VCA_SIT_QUIETLY(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "dwDuration", "byRes");
		}
	}

	public static class NET_VCA_HIGH_DENSITY_STATUS extends Structure {
		public NET_VCA_POLYGON   struRegion = new NET_VCA_POLYGON();
		public float             fDensity;
		public byte              bySensitivity;
		public byte[]            byRes = new byte[3];

		public NET_VCA_HIGH_DENSITY_STATUS(Pointer p) {
			super(p);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "fDensity", "bySensitivity", "byRes");
		}
	}

	public static class NET_VCA_EVENT_UNION extends Union
	{
		public int[] uLen = new int[23];
		//not list all the event structure,it's too slow,see COMM_ALARM_RULE in JNATest
	}

	public static class NET_VCA_RULE_INFO extends Structure {
		public byte             byRuleID;
		public byte             byRes;
		public short            wEventTypeEx;
		public byte[]           byRuleName = new byte[NAME_LEN];
		public int              dwEventType;
		public NET_VCA_EVENT_UNION   uEventParam = new NET_VCA_EVENT_UNION();
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byRuleID", "byRes", "wEventTypeEx", "byRuleName", "dwEventType", "uEventParam");
		}
	}

	public static class NET_VCA_RULE_ALARM extends Structure {
		public int              dwSize;
		public int              dwRelativeTime;
		public int              dwAbsTime;
		public NET_VCA_RULE_INFO     struRuleInfo = new NET_VCA_RULE_INFO();
		public NET_VCA_TARGET_INFO   struTargetInfo = new NET_VCA_TARGET_INFO();
		public NET_VCA_DEV_INFO      struDevInfo = new NET_VCA_DEV_INFO();
		public int              dwPicDataLen;
		public byte             byPicType;
		public byte             byRelAlarmPicNum;
		public byte             bySmart;
		public byte             byRes;
		public int              dwAlarmID;
		public byte[]           byRes2 = new byte[8];
		public ByteByReference  pImage;

		public NET_VCA_RULE_ALARM(Pointer p){
			super(p);
		}
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwRelativeTime", "dwAbsTime", "struRuleInfo", "struTargetInfo", "struDevInfo",
					"dwPicDataLen", "byPicType", "byRelAlarmPicNum", "bySmart", "byRes", "dwAlarmID", "byRes2", "pImage");
		}
	}

	public static class NET_DVR_STREAM_INFO extends Structure {
		public int dwSize;
		public byte[] byID = new byte[STREAM_ID_LEN];
		public int dwChannel;
		public byte[] byRes = new byte[32];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byID", "dwChannel",
					"byRes");
		}
	}

	public static class NET_DVR_MULTI_STREAM_COMPRESSIONCFG_COND extends
			Structure {
		public int dwSize;
		public NET_DVR_STREAM_INFO struStreamInfo = new NET_DVR_STREAM_INFO();
		public int dwStreamType;
		public byte byRes[] = new byte[32];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "struStreamInfo",
					"dwStreamType", "byRes");
		}
	}

	public static class NET_DVR_COMPRESSION_INFO_V30 extends Structure {
		public byte byStreamType;
		public byte byResolution;
		public byte byBitrateType;
		public byte byPicQuality;
		public int dwVideoBitrate;
		public int dwVideoFrameRate;
		public short wIntervalFrameI;
		public byte byIntervalBPFrame;
		public byte byENumber;
		public byte byVideoEncType;
		public byte byAudioEncType;
		public byte[] byres = new byte[10];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byStreamType", "byResolution",
					"byBitrateType", "byPicQuality", "dwVideoBitrate",
					"dwVideoFrameRate", "wIntervalFrameI", "byIntervalBPFrame",
					"byENumber", "byVideoEncType", "byAudioEncType", "byres");
		}
	}

	public static class NET_DVR_MULTI_STREAM_COMPRESSIONCFG extends Structure {
		public int dwSize;
		public int dwStreamType;
		public NET_DVR_COMPRESSION_INFO_V30 struStreamPara = new NET_DVR_COMPRESSION_INFO_V30();
		public byte[] byRes = new byte[80];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwStreamType",
					"struStreamPara", "byRes");
		}
	}

	public static class INT_ARRAY extends Structure {
		public int[] iValue;

		public INT_ARRAY(int iLen) {
			iValue = new int[iLen];
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("iValue");
		}
	}

	public static class BYTE_ARRAY extends Structure {
		public byte[] byValue;

		public BYTE_ARRAY(int iLen) {
			byValue = new byte[iLen];
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byValue");
		}
	}



	public static class NET_DVR_LOITERING_REGION extends Structure {
		public NET_VCA_POLYGON struRegion = new NET_VCA_POLYGON();
		public byte bySensitivity;
		public byte byTimeThreshold;
		public byte[] byRes = new byte[62];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRegion", "bySensitivity",
					"byTimeThreshold", "byRes");
		}
	}

	public static class NET_DVR_LOITERING_DETECTION extends Structure {
		public int dwSize;
		public byte byEnabled;
		public byte[] byRes1 = new byte[3];
		public NET_DVR_LOITERING_REGION[] struRegion = (NET_DVR_LOITERING_REGION[]) new NET_DVR_LOITERING_REGION()
				.toArray(MAX_REGION_NUM);
		public byte[] byRes2 = new byte[128];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byEnabled",
					"byRes1", "struRegion", "byRes2");
		}
	}

	public static class NET_DVR_SMART_REGION_COND extends Structure {
		public int dwSize;
		public int dwChannel;
		public int dwRegion;

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwChannel",
					"dwRegion");
		}
	}

	public static class NET_DVR_INPUTVOLUME extends Structure {
		public int dwSize;
		public byte byAudioInputChan;
		public byte[] byRes = new byte[63];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byAudioInputChan",
					"byRes");
		}
	}

	public static class NET_DVR_CARD_CFG_COND extends Structure {
		public int dwSize;
		public int dwCardNum;
		public byte byCheckCardNo;
		public byte[] byRes = new byte[31];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwCardNum",
					"byCheckCardNo", "byRes");
		}
	}

	public static class NET_DVR_VALID_PERIOD_CFG extends Structure {
		public byte byEnable;
		public byte[] byRes1 = new byte[3];
		public NET_DVR_TIME_EX struBeginTime = new NET_DVR_TIME_EX();
		public NET_DVR_TIME_EX struEndTime = new NET_DVR_TIME_EX();
		public byte[] byRes2 = new byte[32];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byEnable", "byRes1",
					"struBeginTime", "struEndTime", "byRes2");
		}
	}

	public static class arrayCardRightPlan extends Structure {
		public byte[] byDoorRightPlan = new byte[MAX_CARD_RIGHT_PLAN_NUM];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byDoorRightPlan");
		}
	}

	public static class NET_DVR_CARD_CFG extends Structure {
		public int dwSize;
		public int dwModifyParamType;
		public byte[] byCardNo = new byte[ACS_CARD_NO_LEN];
		public byte byCardValid;
		public byte byCardType;
		public byte byLeaderCard;
		public byte byRes1;
		public int dwDoorRight;
		public NET_DVR_VALID_PERIOD_CFG struValid = new NET_DVR_VALID_PERIOD_CFG();
		public int dwBelongGroup;
		public byte[] byCardPassword = new byte[CARD_PASSWORD_LEN];
		public arrayCardRightPlan[] byCardRightPlan = new arrayCardRightPlan[MAX_DOOR_NUM];
		public int dwMaxSwipeTime;
		public int dwSwipeTime;
		public short wRoomNumber;
		public short wFloorNumber;
		public byte[] byRes2 = new byte[20];

		public NET_DVR_CARD_CFG(Pointer p) {
			super(p);
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwModifyParamType",
					"byCardNo", "byCardValid", "byCardType", "byLeaderCard",
					"byRes1", "dwDoorRight", "struValid", "dwBelongGroup",
					"byCardPassword", "byCardRightPlan", "dwMaxSwipeTime",
					"dwSwipeTime", "wRoomNumber", "wFloorNumber", "byRes2");
		}
	}

	public static class NET_DVR_LED_AREA_COND extends Structure
	{
		public int dwSize;
		public int dwVideoWallNo;
		public int dwLEDAreaNo;
		public byte[] byRes = new byte[32];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize","dwVideoWallNo",
					"dwLEDAreaNo","byRes");
		}
	}

	public static class NET_DVR_RECTCFG_EX extends Structure
	{
		public int  dwXCoordinate;
		public int  dwYCoordinate;
		public int  dwWidth;
		public int  dwHeight;
		public byte [] byRes= new byte[4];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwXCoordinate","dwYCoordinate",
					"dwWidth","dwHeight","byRes");
		}
	}

	public static class NET_DVR_LED_AREA_INFO extends Structure
	{
		public int dwSize;
		public int dwLEDAreaNo;
		public NET_DVR_RECTCFG_EX struRect = new NET_DVR_RECTCFG_EX();
		public int []dwaOutputNo= new int[MAX_NUM_OUTPUT_CHANNEL];
		public byte byAreaType;
		public byte [] byRes= new byte[31];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize","dwLEDAreaNo","struRect",
					"dwaOutputNo","byAreaType", "byRes");
		}
	}

	public static class NET_DVR_LED_AREA_INFO_LIST extends Structure
	{
		public int dwSize;
		public int dwLEDAreaNum;
		public Pointer lpstruBuffer;
		public int dwBufferSize;
		public byte [] byRes= new byte[32];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize","dwLEDAreaNum","lpstruBuffer",
					"dwBufferSize","byRes");
		}
	}

	public static class NET_DVR_MATRIX_PASSIVEMODE extends Structure
	{
		public short	wTransProtol;
		public short	wPassivePort;
		public NET_DVR_IPADDR	struMcastIP = new NET_DVR_IPADDR();
		public byte	    byStreamType;
		public byte[]	byRes= new byte[7];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("wTransProtol","wPassivePort",
					"struMcastIP","byStreamType","byRes");
		}
	}

	public static class NET_DVR_ALARMHOST_OTHER_STATUS_V50 extends Structure
	{
		public int dwSize;
		public byte[]	bySirenStatus = new byte[ALARMHOST_MAX_SIREN_NUM];
		public byte[]	byDetetorPower = new byte[MAX_DETECTOR_NUM];
		public byte[]	byDetetorConnection = new byte[MAX_DETECTOR_NUM];
		public byte[]	byRes= new byte[1024];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize","bySirenStatus","byDetetorPower","byDetetorConnection","byRes");
		}
	}

	public static class NET_DVR_NOAMAL_SUB_SYSTEM extends Structure
	{
		public int 		dwBeJoinedSubSystem;
		public byte[]	byRes= new byte[16];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwBeJoinedSubSystem","byRes");
		}
	}

	public static class NET_DVR_PUBLIC_SUB_SYSTEM extends Structure
	{
		public int 		dwJointSubSystem;
		public byte[]	byRes= new byte[16];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwJointSubSystem","byRes");
		}
	}

	public static class NET_DVR_JOINT_SUB_SYSTEM extends Union
	{
		public NET_DVR_NOAMAL_SUB_SYSTEM	struNormalSubSystem = new NET_DVR_NOAMAL_SUB_SYSTEM();
		public NET_DVR_PUBLIC_SUB_SYSTEM	struPublicSubSystem = new NET_DVR_PUBLIC_SUB_SYSTEM();
		public byte[]	byRes= new byte[20];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struNormalSubSystem","struPublicSubSystem","byRes");
		}
	}

	public static class NET_DVR_ALARMSUBSYSTEMPARAM extends Structure
	{
		public int		dwSize;
		public short	wEnterDelay;
		public short	wExitDelay;
		public byte	    byHostageReport;
		public byte	    bySubsystemEnable;
		public byte	    byKeyToneOfArmOrDisarm;
		public byte	    byKeyToneOfManualTestReport;
		public short	wDelayTime;
		public byte	    byEnableAlarmInDelay;
		public byte	    byPublicAttributeEnable;
		public NET_DVR_JOINT_SUB_SYSTEM	struJointSubSystem = new NET_DVR_JOINT_SUB_SYSTEM();
		public byte	    byKeyZoneArm;
		public byte	    byKeyZoneArmReport;
		public byte	    byKeyZoneDisarm;
		public byte	    byKeyZoneDisarmReport;
		public byte[]	bySubSystemID = new byte[MAX_SUBSYSTEM_ID_LEN];
		public byte	    byKeyZoneArmReportEnable;
		public byte	    byKeyZoneArmEnable;
		public byte	    byOneKeySetupAlarmEnable;
		public byte	    bySingleZoneSetupAlarmEnable;
		public byte	    byCenterType;
		public byte[]	sCenterAccount = new byte[ACCOUNTNUM_LEN];
		public byte[]	sCenterAccountV40 = new byte[ACCOUNTNUM_LEN_32];
		public byte[]	byRes2 = new byte[565];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize","wEnterDelay","wExitDelay","byHostageReport","bySubsystemEnable"
					,"byKeyToneOfArmOrDisarm","byKeyToneOfManualTestReport","wDelayTime","byEnableAlarmInDelay","byPublicAttributeEnable"
					,"struJointSubSystem","byKeyZoneArm","byKeyZoneArmReport","byKeyZoneDisarm","byKeyZoneDisarmReport"
					,"bySubSystemID","byKeyZoneArmReportEnable","byKeyZoneArmEnable","byOneKeySetupAlarmEnable","bySingleZoneSetupAlarmEnable"
					,"byCenterType","sCenterAccount","sCenterAccountV40","byRes2");
		}
	}

	public static class NET_DVR_WALLWIN_INFO extends Structure
	{
		public int 		dwSize;
		public int		dwWinNum;
		public int		dwSubWinNum;
		public int		dwWallNo;
		public byte[]	byRes = new byte[12];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize","dwWinNum","dwSubWinNum","dwWallNo","byRes");
		}
	}

	public static class NET_DVR_WALL_WIN_STATUS extends Structure
	{
		public int 		dwSize;
		public byte 	byDecodeStatus;
		public byte 	byStreamType;
		public byte 	byPacketType;
		public byte 	byFpsDecV;
		public byte 	byFpsDecA;
		public byte[] 	byRes1 = new byte[7];
		public int 		dwDecodedV;
		public int 		dwDecodedA;
		public short 	wImgW;
		public short 	wImgH;
		public byte 	byStreamMode;
		public byte[] 	byRes2 = new byte[31];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize","byDecodeStatus","byStreamType","byPacketType","byFpsDecV",
					"byFpsDecA","byRes1","dwDecodedV","dwDecodedA","wImgW",
					"wImgH","byStreamMode","byRes2");
		}
	}
	public static class NET_DVR_SETUPALARM_PARAM extends Structure
	{
		public int		dwSize;
		public byte		byLevel;
		public byte		byAlarmInfoType;
		public byte 	byRetAlarmTypeV40;
		public byte 	byRetDevInfoVersion;
		public byte 	byRetVQDAlarmType;
		public byte 	byFaceAlarmDetection;
		public byte 	bySupport;
		public byte 	byBrokenNetHttp;
		public short	wTaskNo;
		public byte[]   byRes1 = new byte[6];

		protected List<String>	getFieldOrder(){
			return Arrays.asList("dwSize", "byLevel", "byAlarmInfoType",
					"byRetAlarmTypeV40", "byRetDevInfoVersion", "byRetVQDAlarmType",
					"byFaceAlarmDetection", "bySupport", "byBrokenNetHttp", "wTaskNo", "byRes1");
		}
	}

	public static class NET_DVR_DEVICEINFO_V30 extends Structure
	{
		public  byte[] 	sSerialNumber = new byte[SERIALNO_LEN];
		public  byte 	byAlarmInPortNum;
		public  byte 	byAlarmOutPortNum;
		public  byte 	byDiskNum;
		public  byte 	byDVRType;
		public  byte 	byChanNum;
		public  byte 	byStartChan;
		public  byte 	byAudioChanNum;
		public  byte 	byIPChanNum;
		public  byte[] 	byRes1 = new byte[24];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("sSerialNumber", "byAlarmInPortNum", "byAlarmOutPortNum",
					"byDiskNum", "byDVRType", "byChanNum", "byStartChan", "byAudioChanNum", "byIPChanNum", "byRes1");
		}
	}

	public static class NET_DVR_DEVICEINFO_V40 extends Structure
	{
		public NET_DVR_DEVICEINFO_V30 struDeviceV30 = new NET_DVR_DEVICEINFO_V30();
		public byte bySupportLock;
		public byte byRetryLoginTime;
		public byte byPasswordLevel;
		public byte byRes1;
		public int  dwSurplusLockTime;
		public byte byCharEncodeType;
		public byte[] byRes2 = new byte[255];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struDeviceV30", "bySupportLock", "byRetryLoginTime",
					"byPasswordLevel", "byRes1", "dwSurplusLockTime", "byCharEncodeType", "byRes2");
		}
	}


	public static class NET_DVR_USER_LOGIN_INFO extends Structure
	{
		public byte[] sDeviceAddress = new byte[NET_DVR_DEV_ADDRESS_MAX_LEN];
		public byte byRes1;
		public short wPort;
		public byte[] sUserName = new byte[NET_DVR_LOGIN_USERNAME_MAX_LEN];
		public byte[] sPassword = new byte[NET_DVR_LOGIN_PASSWD_MAX_LEN];
		public FLoginResultCallBack cbLoginResult;
		public Pointer pUser;
		public boolean bUseAsynLogin;
		public byte[] byRes2 = new byte[128];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("sDeviceAddress", "byRes1", "wPort", "sUserName", "sPassword",
					"cbLoginResult", "pUser", "bUseAsynLogin", "byRes2");
		}
	}


	public static class NET_DVR_OPEN_EZVIZ_USER_LOGIN_INFO extends Structure
	{
		public byte[] sEzvizServerAddress = new byte[NET_DVR_DEV_ADDRESS_MAX_LEN];
		public byte[] byRes1 = new byte[3];
		public short wPort;
		public byte[] byRes2 = new byte[2];
		public byte[] sUrl = new byte[EZVIZ_REQURL_LEN];
		public byte[] sAccessToken = new byte[EZVIZ_ACCESSTOKEN_LEN];
		public byte[] sDeviceID = new byte[EZVIZ_DEVICEID_LEN];
		public byte[] sClientType = new byte[EZVIZ_CLIENTTYPE_LEN];
		public byte[] sFeatureCode = new byte[EZVIZ_FEATURECODE_LEN];
		public byte[] sOsVersion = new byte[EZVIZ_OSVERSION_LEN];
		public byte[] sNetType = new byte[EZVIZ_NETTYPE_LEN];
		public byte[] sSdkVersion = new byte[EZVIZ_SDKVERSION_LEN];
		public byte[] sAppID = new byte[EZVIZ_APPID_LEN];
		public byte[] byRes3 = new byte[512];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("sEzvizServerAddress", "byRes1", "wPort", "byRes2", "sUrl",
					"sAccessToken", "sDeviceID", "sClientType", "sFeatureCode",
					"sOsVersion", "sNetType", "sSdkVersion", "sAppID", "byRes3");
		}
	}

	public static class NET_DVR_VIDEO_CALL_COND extends Structure
	{
		public int		dwSize;
		public byte[] byRes = new byte[128];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byRes");
		}
	}

	public static class NET_DVR_VIDEO_CALL_PARAM extends Structure
	{
		public int		dwSize;
		public int		dwCmdType;
		public byte[] byRes = new byte[128];

		public NET_DVR_VIDEO_CALL_PARAM()
		{
			super();
		}
		public NET_DVR_VIDEO_CALL_PARAM(Pointer p) {
			super(p);
		}
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwCmdType", "byRes");
		}
	}

	public class NET_DVR_DEV_CHAN_INFO extends Structure {
		/** DVR IP address */
		public NET_DVR_IPADDR struIP = new NET_DVR_IPADDR();
		/** DVR PORT */
		public short  wDVRPort;
		/** Channel */
		public byte   byChannel;
		/** Transmit protocol:0-TCP, 1-UDP */
		public byte	  byTransProtocol;
		/** Stream mode: 0-main stream, 1-sub stream */
		public byte	  byTransMode;
		/** IPC factory type */
		public byte	  byFactoryType;
		/** Device type(Used by videoplatfom VCA card),
		 *  1-decoder(use decode channel No. or display channel depends on byVcaSupportChanMode in video platform ability structure),
		 *  2-coder
		 */
		public byte	  byDeviceType;
		/** Display channel No. used by VCA configuration */
		public byte   byDispChan;
		/** Display sub channel No. used by VCA configuration */
		public byte	  bySubDispChan;
		/** Resolution: 1-CIF 2-4CIF 3-720P 4-1080P 5-500w used by big screen controler */
		public byte	  byResolution;
		/** reserved */
		public byte[] byRes = new byte[2];
		/** Device domain name */
		public byte[] sDomain = new byte[MAX_DOMAIN_NAME];
		/** Remote device user name */
		public byte[] sUserName = new byte[NAME_LEN];
		/** Remote device password */
		public byte[] sPassword = new byte[PASSWD_LEN];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struIP", "wDVRPort", "byChannel", "byTransProtocol", "byTransMode",
					"byFactoryType", "byDeviceType", "byDispChan", "bySubDispChan",
					"byResolution", "byRes", "sDomain", "sUserName", "sPassword");
		}
	}


	public static class NET_DVR_SUBSYSTEM_BASIC_INFO extends Structure
	{
		public int		dwSize;
		public byte  bySubSystemType;
		public byte  bySubSystemNo ;
		public byte  [] byRes1 = new byte[2];
		public int		dwChan;
		public NET_DVR_IPADDR   struSubSystemIP;
		public NET_DVR_IPADDR   struSubSystemIPMask;
		public NET_DVR_IPADDR	 struGatewayIpAddr;
		public short wSubSystemPort;
		public byte  []byRes2 = new byte[6];
		public byte  []sSerialNumber  = new byte[SERIALNO_LEN];
		public byte  byBelongBoard;
		public byte [] byRes3 = new byte[3];
		public byte  []byDeviceName = new byte[20];
		public int		dwStartChanNo;
		public byte  byDevNo;
		public byte  [] byRes4 = new byte[63];

		public NET_DVR_SUBSYSTEM_BASIC_INFO(Pointer p) {
			super(p);
		}

		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "bySubSystemType", "bySubSystemNo", "byRes1", "dwChan",
					"struSubSystemIP", "struSubSystemIPMask", "struGatewayIpAddr", "wSubSystemPort", "byRes2",
					"sSerialNumber", "byBelongBoard", "byRes3", "byDeviceName", "dwStartChanNo",
					"byDevNo", "byRes4");
		}
	}

	public class NET_DVR_STREAM_MEDIA_SERVER_CFG extends Structure {
		/** Is enable */
		public byte   byValid;
		/** reserved1 */
		public byte[] byRes1 = new byte[3];
		/** stream server IP */
		public NET_DVR_IPADDR struDevIP = new NET_DVR_IPADDR();
		/** stream server Port */
		public short  wDevPort;
		/** Protocol: 0-TCP, 1-UDP */
		public byte   byTransmitType;
		/** reserved2 */
		public byte[] byRes2 = new byte[69];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byValid", "byRes1", "struDevIP", "wDevPort", "byTransmitType", "byRes2");
		}
	}

	public class NET_DVR_PU_STREAM_CFG extends Structure {
		public int dwSize;
		public NET_DVR_STREAM_MEDIA_SERVER_CFG	struStreamMediaSvrCfg = new NET_DVR_STREAM_MEDIA_SERVER_CFG();
		public NET_DVR_DEV_CHAN_INFO		    struDevChanInfo = new NET_DVR_DEV_CHAN_INFO();
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "struStreamMediaSvrCfg", "struDevChanInfo");
		}
	}

	public class NET_DVR_VIDEOEFFECT extends Structure {
		public byte byBrightnessLevel;  /*0- 100*/
		public byte byContrastLevel;  /*0- 100*/
		public byte bySharpnessLevel;  /*0- 100*/
		public byte bySaturationLevel;  /*0- 100*/
		public byte byHueLevel;  /*0- 100,  (Reserved) */
		public byte byEnableFunc; //enable,bit0-SMART IR,bit1-illumination,bit2-light inhibit,0-no,1-yes
		public byte byLightInhibitLevel; //light inhibit level,[1-3]
		public byte byGrayLevel; //gray level,0-[0-255],1-[16-235]
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byBrightnessLevel", "byContrastLevel", "bySharpnessLevel", "bySaturationLevel", "byHueLevel",
					"byEnableFunc", "byLightInhibitLevel", "byGrayLevel");
		}
	}

	public static class NET_DVR_INPUTSTREAMCFG_V40 extends Structure
	{
		public int dwSize;
		/** 0-invalid, !0-valid */
		public byte   byValid;
		/** reference to NET_DVR_CAM_MODE */
		public byte   byCamMode;
		/** input signal No. */
		public short  wInputNo;
		/** signal name */
		public byte[] sCamName = new byte[NAME_LEN];
		/** video effect parameters */
		public NET_DVR_VIDEOEFFECT 	 struVideoEffect = new NET_DVR_VIDEOEFFECT();
		/** IP signal configurations */
		public NET_DVR_PU_STREAM_CFG struPuStream = new NET_DVR_PU_STREAM_CFG();
		/** sub board No., read only */
		public short  wBoardNum;
		/** index of signal in sub board, read only */
		public short  wInputIdxOnBoard;
		/** resolution */
		public int	  dwResolution;
		/** video format, reference to VIDEO_STANDARD */
		public byte   byVideoFormat;
		/** signal status,0-invalid, 1-signal normal, 2-no signal, 3-exception  */
		public byte	  byStatus;
		/** signal group name */
		public byte[] sGroupName = new byte[NAME_LEN];
		/** relate matrix, 0-not related, 1-related,
		 *  valid when signal type is NET_DVR_CAM_BNC or NET_DVR_CAM_VGA or NET_DVR_CAM_DVI or NET_DVR_CAM_HDMI
		 */
		public byte	  byJointMatrix;
		/** joint No., read only */
		public byte	  byJointNo;
		/** color mode, 0-self define, 1-sharp, 2-normal,
		 *  3-soft,struVideoEffect is valid when color mode is self define
		 */
		public byte	  byColorMode;

		public byte	  byScreenServer;
		public byte	  byRes1[]= new byte[2];
		public int    dwInputSignalNo;

		/** reserved */
		public byte[] byRes = new byte[120];

		public NET_DVR_INPUTSTREAMCFG_V40() {

		}

		public NET_DVR_INPUTSTREAMCFG_V40(Pointer p) {
			super(p);
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byValid", "byCamMode", "wInputNo", "sCamName", "struVideoEffect",
					"struPuStream", "wBoardNum", "wInputIdxOnBoard", "dwResolution", "byVideoFormat", "byStatus",
					"sGroupName", "byJointMatrix", "byJointNo", "byColorMode", "byScreenServer", "byRes1",
					"dwInputSignalNo", "byRes");
		}
	}

	public static class NET_DVR_INPUT_SIGNAL_LIST extends Structure
	{
		public int dwSize;
		public int dwInputSignalNums;
		public Pointer pBuffer;
		public byte byRes1[] = new byte[3];
		public int dwBufLen;
		public byte byRes2[] = new byte[64];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwInputSignalNums", "pBuffer", "byRes1", "dwBufLen", "byRes2");
		}
	}

	public static class NET_DVR_VEHICLE_CONTROL_ALARM extends Structure
	{
		public int dwSize;
		public byte  byListType;
		public byte  byPlateType;
		public byte  byPlateColor;
		public byte  byRes1;
		public byte[] sLicense = new byte[MAX_LICENSE_LEN];
		public byte[] sCardNo = new byte[MAX_CARDNO_LEN];
		public NET_DVR_TIME_V30 struAlarmTime = new NET_DVR_TIME_V30();
		public int dwChannel;
		public int dwPicDataLen;
		public byte  byPicType;
		public byte  byRes3[] = new byte[3];
		public ByteByReference pPicData;
		public byte  byRes2[] = new byte[48];
		public NET_DVR_VEHICLE_CONTROL_ALARM(Pointer p){
			super(p);
		}
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byListType", "byPlateType", "byPlateColor", "byRes1", "sLicense",
					"sCardNo","struAlarmTime", "dwChannel", "dwPicDataLen", "byPicType", "byRes3","pPicData","byRes2");
		}
	}

	public static class NET_VCA_HUMAN_FEATURE extends Structure
	{
		public byte byAgeGroup;
		public byte bySex;
		public byte byEyeGlass;
		public byte byAge;
		public byte byAgeDeviation;
		public byte[] byRes = new byte[11];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byAgeGroup", "bySex", "byEyeGlass", "byAge", "byAgeDeviation", "byRes");
		}
	}

	public static class NET_DVR_FACE_DETECTION extends Structure
	{
		public int dwSize;
		public int dwRelativeTime;
		public int dwAbsTime;
		public int dwBackgroundPicLen;
		public NET_VCA_DEV_INFO struDevInfo = new NET_VCA_DEV_INFO();
		public NET_VCA_RECT[] struFacePic = (NET_VCA_RECT[])new NET_VCA_RECT().toArray(MAX_FACE_PIC_NUM);
		public byte byFacePicNum;
		public byte byRes1;
		public short wDevInfoIvmsChannelEx;
		public byte[] byRes = new byte[252];
		public ByteByReference pBackgroundPicpBuffer;
		public NET_DVR_FACE_DETECTION(Pointer p){
			super(p);
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwRelativeTime", "dwAbsTime", "dwBackgroundPicLen", "struDevInfo", "struFacePic",
					"byFacePicNum","byRes1", "wDevInfoIvmsChannelEx", "byRes", "pBackgroundPicpBuffer");
		}
	}

	public static class NET_VCA_FACESNAP_RESULT extends Structure
	{
		public int dwSize;
		public int dwRelativeTime;
		public int dwAbsTime;
		public int dwFacePicID;
		public int dwFaceScore;
		public NET_VCA_TARGET_INFO struTargetInfo = new NET_VCA_TARGET_INFO();
		public NET_VCA_RECT struRect = new NET_VCA_RECT();
		public NET_VCA_DEV_INFO struDevInfo = new NET_VCA_DEV_INFO();
		public int dwFacePicLen;
		public int dwBackgroundPicLen;
		public byte bySmart;
		public byte byAlarmEndMark;
		public byte byRepeatTimes;
		public byte byUploadEventDataType;
		public NET_VCA_HUMAN_FEATURE struFeature = new NET_VCA_HUMAN_FEATURE();
		public float fStayDuration;
		public byte[]  sStorageIP = new byte[16];
		public short wStoragePort;
		public short wDevInfoIvmsChannelEx;
		public byte[] byRes1 = new byte[16];
		public ByteByReference pBuffer1;
		public ByteByReference pBuffer2;
		public NET_VCA_FACESNAP_RESULT(Pointer p){
			super(p);
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwRelativeTime", "dwAbsTime", "dwFacePicID", "dwFaceScore", "struTargetInfo",
					"struRect","struDevInfo", "dwFacePicLen", "dwBackgroundPicLen", "bySmart", "byAlarmEndMark", "byRepeatTimes",
					"byUploadEventDataType", "struFeature", "fStayDuration", "sStorageIP", "wStoragePort",
					"wDevInfoIvmsChannelEx", "byRes1", "pBuffer1", "pBuffer2");
		}
	}

	public static class NET_VCA_FACESNAP_INFO_ALARM extends Structure
	{
		public int dwRelativeTime;
		public int dwAbsTime;
		public int dwSnapFacePicID;
		public int dwSnapFacePicLen;
		public NET_VCA_DEV_INFO struDevInfo = new NET_VCA_DEV_INFO();
		public byte byFaceScore;
		public byte bySex;
		public byte byGlasses;
		public byte byAge;
		public byte byAgeDeviation;
		public byte[] byRes1 = new byte[3];
		public int dwUIDLen;
		public ByteByReference pUIDBuffer;
		public byte[] byRes = new byte[4];
		public ByteByReference pBuffer1;

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwRelativeTime", "dwAbsTime", "dwSnapFacePicID", "dwSnapFacePicLen", "struDevInfo", "byFaceScore",
					"bySex","byGlasses", "byAge", "byAgeDeviation", "byRes1","dwUIDLen","pUIDBuffer","byRes","pBuffer1");
		}
	}

	public static class NET_DVR_AREAINFOCFG extends Structure
	{
		public short wNationalityID;
		public short wProvinceID;
		public short wCityID;
		public short wCountyID;
		public int dwCode;

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("wNationalityID", "wProvinceID", "wCityID", "wCountyID", "dwCode");
		}
	}

	public static class NET_VCA_HUMAN_ATTRIBUTE extends Structure
	{
		public byte bySex;
		public byte byCertificateType;
		public byte[] byBirthDate = new byte[MAX_HUMAN_BIRTHDATE_LEN];
		public byte[] byName = new byte[NAME_LEN];
		public NET_DVR_AREAINFOCFG struNativePlace = new NET_DVR_AREAINFOCFG();
		public byte[] byCertificateNumber = new byte[NAME_LEN];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("bySex", "byCertificateType", "byBirthDate", "byName", "struNativePlace", "byCertificateNumber");
		}
	}

	public static class NET_VCA_BLACKLIST_INFO extends Structure
	{
		public int dwSize;
		public int dwRegisterID;
		public int dwGroupNo;
		public int byType;
		public int byLevel;
		public byte[] byRes1 = new byte[2];
		public NET_VCA_HUMAN_ATTRIBUTE struAttribute = new NET_VCA_HUMAN_ATTRIBUTE();
		public byte[] byRemark = new byte[NAME_LEN];
		public int dwFDDescriptionLen;
		public ByteByReference pFDDescriptionBuffer;
		public byte[] byRes2 = new byte[12];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwRegisterID", "dwGroupNo", "byType", "byLevel", "byRes1",
					"struAttribute","byRemark", "dwFDDescriptionLen", "pFDDescriptionBuffer", "byRes2");
		}
	}

	public static class NET_VCA_BLACKLIST_INFO_ALARM extends Structure
	{
		public NET_VCA_BLACKLIST_INFO struBlackListInfo = new NET_VCA_BLACKLIST_INFO();
		public int dwBlackListPicLen;
		public int dwFDIDLen;
		public ByteByReference pFDID;
		public int dwPIDLen;
		public ByteByReference pPID;
		public short wThresholdValue;
		public byte[] byRes = new byte[2];
		public ByteByReference pBuffer1;

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struBlackListInfo", "dwBlackListPicLen", "dwFDIDLen", "pFDID", "dwPIDLen", "pPID",
					"wThresholdValue","byRes", "pBuffer1");
		}
	}

	public static class NET_VCA_FACESNAP_MATCH_ALARM extends Structure
	{
		public int dwSize;
		public float fSimilarity;
		public NET_VCA_FACESNAP_INFO_ALARM struSnapInfo = new NET_VCA_FACESNAP_INFO_ALARM();
		public NET_VCA_BLACKLIST_INFO_ALARM struBlackListInfo = new NET_VCA_BLACKLIST_INFO_ALARM();
		public byte[] sStorageIP = new byte[16];
		public short wStoragePort;
		public byte byMatchPicNum;
		public byte byPicTransType;
		public int dwSnapPicLen;
		public ByteByReference pSnapPicBuffer;
		public NET_VCA_RECT struRegion = new NET_VCA_RECT();
		public int dwModelDataLen;
		public ByteByReference pModelDataBuffer;
		public byte[] byRes = new byte[8];
		public NET_VCA_FACESNAP_MATCH_ALARM(Pointer p){
			super(p);
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "fSimilarity", "struSnapInfo", "struBlackListInfo", "sStorageIP", "wStoragePort",
					"byMatchPicNum","byPicTransType","dwSnapPicLen", "pSnapPicBuffer","struRegion","dwModelDataLen",
					"pModelDataBuffer","byRes");
		}
	}

	public static class  struStartFrame extends Structure{
		public int dwRelativeTime;
		public int dwAbsTime;
		public byte[] byRes = new byte[92];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwRelativeTime","dwAbsTime", "byRes");
		}
	}

	public static class  struStartTime extends Structure{
		public NET_DVR_TIME tmStart = new NET_DVR_TIME();
		public NET_DVR_TIME tmEnd = new NET_DVR_TIME();
		public byte[] byRes = new byte[92];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("tmStart","tmEnd", "byRes");
		}
	}

	public static class unionStartModeParam extends Union{
		public struStartFrame struStartFrame = new struStartFrame();
		public struStartTime struStartTime = new struStartTime();
	}

	public static class NET_DVR_PDC_ALRAM_INFO extends Structure
	{
		public int dwSize;
		public byte byMode;
		public byte byChannel;
		public byte bySmart;
		public byte byRes1;
		public NET_VCA_DEV_INFO struDevInfo = new NET_VCA_DEV_INFO();
		public unionStartModeParam unionStartModeParam= new unionStartModeParam();
		public int dwLeaveNum;
		public int dwEnterNum;
		public byte byBrokenNetHttp;
		public byte byRes3;
		public short wDevInfoIvmsChannelEx;
		public int dwPassingNum;
		public byte[] byRes = new byte[32];
		public NET_DVR_PDC_ALRAM_INFO(Pointer p){
			super(p);
		}

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byMode", "byChannel", "bySmart", "byRes1", "struDevInfo","unionStartModeParam",
					"dwLeaveNum","dwEnterNum", "byBrokenNetHttp", "byRes3", "wDevInfoIvmsChannelEx","dwPassingNum","byRes");
		}

	}

	public static class NET_DVR_FACELIB_COND extends Structure
	{
		public int dwSize;
		public byte[] szFDID = new byte[NET_SDK_MAX_FDID_LEN];
		public byte byConcurrent;
		public byte[] byRes = new byte[127];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "szFDID", "byConcurrent", "byRes");
		}
	}

	public class NET_SDK_UPLOAD_TYPE {
		public static final int UPGRADE_CERT_FILE = 0;
		public static final int UPLOAD_CERT_FILE = 1;
		public static final int TRIAL_CERT_FILE = 2;
		public static final int CONFIGURATION_FILE = 3;
		public static final int UPLOAD_RECORD_FILE = 4;
		public static final int SCENE_CONFIGURATION_FILE = 5;
		public static final int UPLOAD_PICTURE_FILE = 6;
		public static final int UPLOAD_VIOLATION_FILE = 7;
		public static final int UPLOAD_TG_FILE = 8;
		public static final int UPLOAD_DATA_TO_DB = 9;
		public static final int UPLOAD_BACKGROUND_PIC = 10;
		public static final int UPLOAD_CALIBRATION_FILE = 11;
		public static final int UPLOAD_TME_FILE = 12;
		public static final int UPLOAD_VEHICLE_BLACKWHITELST_FILE = 13;
		public static final int UPLOAD_PICTURE_TO_CLOUD = 15;
		public static final int UPLOAD_VIDEO_FILE = 16;
		public static final int UPLOAD_SCREEN_FILE = 17;
		public static final int IMPORT_DATA_TO_FACELIB = 39;
	}

	public static class NET_DVR_SEND_PARAM_IN extends Structure
	{
		public Pointer pSendData;
		public int dwSendDataLen;
		public NET_DVR_TIME_V30 struTime;
		public byte byPicType;
		public byte[] byRes1 = new byte[3];
		public int dwPicManageNo;
		public byte[] sPicName = new byte[NAME_LEN];
		public int dwPicDisplayTime;
		public Pointer pSendAppendData;
		public int dwSendAppendDataLen;
		public byte[]  byRes = new byte[192];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("pSendData", "dwSendDataLen", "struTime", "byPicType", "byRes1", "dwPicManageNo",
					"sPicName","dwPicDisplayTime", "pSendAppendData", "dwSendAppendDataLen", "byRes");
		}
	}

	public static class NET_DVR_UPLOAD_FACE_DATA_OUT extends Structure
	{
		public byte[] szPicID = new byte[NET_SDK_MAX_PICID_LEN];
		public byte[] byRes = new byte[128];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("szPicID", "byRes");
		}
	}

	public static class NET_DVR_UPLOAD_FILE_RET extends Structure
	{
		public byte[] sUrl = new byte[MAX_UPLOADFILE_URL_LEN];
		public byte[] byRes = new byte[260];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("sUrl", "byRes");
		}
	}

	public static class NET_DVR_EZVIZ_ACCESS_CFG extends Structure
	{
		public int dwSize;
		public byte byEnable;
		public byte byDeviceStatus;
		public byte byAllowRedirect;
		public byte[] byDomainName = new byte[MAX_DOMAIN_NAME];
		public byte byRes1;
		public byte[] byVerificationCode = new byte[NET_SDK_MAX_VERIFICATION_CODE_LEN];
		public byte byNetMode;
		public byte[] byRes = new byte[411];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byEnable", "byDeviceStatus", "byAllowRedirect", "byDomainName", "byRes1",
					"byVerificationCode","byNetMode", "byRes");
		}
	}


	public static class NET_DVR_SUBSYSTEM_BASIC_INFO_RESPONSE extends Structure
	{
		public int		dwSize;
		public int		dwErrorCode;
		public byte  byDevNo;
		public byte bySubSystemNo ;
		public byte [] byRes = new byte[30];

		public NET_DVR_SUBSYSTEM_BASIC_INFO_RESPONSE(Pointer p){
			super(p);
		}

		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwErrorCode", "byDevNo", "bySubSystemNo", "byRes");
		}
	}


	public static class NET_DVR_AUDIO_INFO extends Structure
	{
		public int		dwSize;
		public byte byAudioChanType;
		public byte [] byRes1 = new byte[3];
		public int		dwAudioNo;
		public byte []byRes2= new byte[16];

		public NET_DVR_AUDIO_INFO(Pointer p){
			super(p);
		}

		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byAudioChanType", "byRes1", "dwAudioNo", "byRes2");
		}
	}

	public static class NET_DVR_DISPLAYPARAM extends Structure
	{
		public int dwDisplayNo;
		public byte  byDispChanType;
		public byte  byRes[] = new byte[11];

		public NET_DVR_DISPLAYPARAM(Pointer p){
			super(p);
		}

		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwDisplayNo", "byDispChanType", "byRes");
		}
	}



	public static class NET_DVR_DISPLAYCFG extends Structure
	{
		public int  dwSize ;
		public NET_DVR_DISPLAYPARAM []struDisplayParam = new NET_DVR_DISPLAYPARAM[MAX_DISPLAY_NUM] ;
		public byte  []byRes = new byte[128];

		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "struDisplayParam", "byRes");
		}
	}


	public static class  NET_DVR_VIDEOWALLDISPLAYPOSITION extends Structure
	{
		public int   dwSize ;
		public byte	byEnable ;
		public byte	[]byRes1 = new byte[3] ;
		public int  	 dwVideoWallNo ;
		public int   dwDisplayNo ;//显示输出号
		public NET_DVR_RECTCFG_EX struRectCfg = new NET_DVR_RECTCFG_EX();
		public byte	[]byRes2 = new byte[64];

		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byEnable", "byRes1","dwVideoWallNo", "dwDisplayNo", "struRectCfg", "byRes2");
		}
	}

	public static class NET_DVR_CURTRIGGERMODE extends Structure{
		public int      dwSize;
		public int      dwTriggerType;
		public byte[]   byRes = new byte[24];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwTriggerType", "byRes");
		}
	}

	public static class NET_ITC_RS485_ACCESS_INFO_COND extends Structure{
		public int      dwSize;
		public int      dwChannel;
		public int      dwTriggerModeType;
		public byte     byAssociateRS485No;
		public byte[]   byRes = new byte[15];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "dwChannel", "dwTriggerModeType", "byAssociateRS485No", "byRes");
		}
	}

	public static class NET_ITC_RADAR_PARAM extends Structure{
		public byte      byRadarType;
		public byte      byLevelAngle;
		public short     wRadarSensitivity;
		public short     wRadarSpeedValidTime;
		public byte[]    byRes1 = new byte[2];
		public float     fLineCorrectParam;
		public int       iConstCorrectParam;
		public byte[]    byRes2 = new byte[8];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byRadarType", "byLevelAngle", "wRadarSensitivity", "wRadarSpeedValidTime", "byRes1", "fLineCorrectParam", "iConstCorrectParam", "byRes2");
		}
	}

	public static class NET_ITC_RADAR_INFO_PARAM extends Structure{
		public NET_ITC_RADAR_PARAM     struRadarParam = new NET_ITC_RADAR_PARAM();
		public byte                    byAssociateLaneNo;
		public byte[]                  byRes = new byte[103];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struRadarParam", "byAssociateLaneNo", "byRes");
		}
	}

	public static class NET_ITC_ACCESS_DEVINFO_PARAM_UNION extends Union
	{
		public byte[]                       uLen = new byte[128];
		public NET_ITC_RADAR_INFO_PARAM     struRadarInfoParam = new NET_ITC_RADAR_INFO_PARAM();
	}

	public static class NET_ITC_RS485_ACCESS_CFG extends Structure{
		public int                                   dwSize;
		public byte                                  byModeType;
		public byte[]                                byRes = new byte[3];
		public NET_ITC_ACCESS_DEVINFO_PARAM_UNION    uITCAccessDevinfoParam = new NET_ITC_ACCESS_DEVINFO_PARAM_UNION();
		public byte[]                                byRes1 = new byte[12];

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "byModeType", "byRes", "uITCAccessDevinfoParam", "byRes1");
		}
	}

	public static class NET_ITC_PLATE_RECOG_PARAM extends Structure{
		public byte[]   byDefaultCHN = new byte[MAX_CHJC_NUM];
		public byte     byEnable;
		public int      dwRecogMode;
		public byte     byVehicleLogoRecog;
		public byte     byProvince;
		public byte     byRegion;
		public byte     byRes1;
		public short    wPlatePixelWidthMin;
		public short    wPlatePixelWidthMax;
		public byte[]   byRes = new byte[24];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byDefaultCHN", "byEnable", "dwRecogMode", "byVehicleLogoRecog", "byProvince", "byRegion", "byRes1", "wPlatePixelWidthMin", "wPlatePixelWidthMax", "byRes");
		}
	}

	public static class NET_ITC_INTERVAL_PARAM extends Structure{
		public byte      byIntervalType;
		public byte[]    byRes1 = new byte[3];
		public short[]   wInterval = new short[MAX_INTERVAL_NUM];
		public byte[]    byRes = new byte[8];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byIntervalType", "byRes1", "wInterval", "byRes");
		}
	}

	public static class NET_ITC_POLYGON extends Structure{
		public int                 dwPointNum;
		public NET_VCA_POINT[]     struPos = (NET_VCA_POINT[])new NET_VCA_POINT().toArray(ITC_MAX_POLYGON_POINT_NUM);

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwPointNum", "struPos");
		}
	}

	public static class unionRegion extends Union{
		public NET_VCA_RECT     struRect = new NET_VCA_RECT();
		public NET_ITC_POLYGON  struPolygon = new NET_ITC_POLYGON();
	}

	public static class NET_ITC_PLATE_RECOG_REGION_PARAM extends Structure{
		public byte          byMode;
		public byte[]        byRes1 = new byte[3];
		public unionRegion   uRegion = new unionRegion();
		public byte[]        byRes = new byte[16];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byMode", "byRes1", "uRegion", "byRes");
		}
	}

	public static class NET_ITC_LANE_PARAM extends Structure{
		public byte                                byEnable;
		public byte                                byRelatedDriveWay;
		public short                               wDistance;
		public short                               wTrigDelayTime;
		public byte                                byTrigDelayDistance;
		public byte                                bySpeedCapEn;
		public byte                                bySignSpeed;
		public byte                                bySpeedLimit;
		public byte                                bySnapTimes;
		public byte                                byOverlayDriveWay;
		public NET_ITC_INTERVAL_PARAM              struInterval = new NET_ITC_INTERVAL_PARAM();
		public byte[]                              byRelatedIOOut = new byte[MAX_IOOUT_NUM];
		public byte                                byFlashMode;
		public byte                                byCartSignSpeed;
		public byte                                byCartSpeedLimit;
		public byte                                byRelatedIOOutEx;
		public NET_ITC_PLATE_RECOG_REGION_PARAM[]  struPlateRecog = (NET_ITC_PLATE_RECOG_REGION_PARAM[])new NET_ITC_PLATE_RECOG_REGION_PARAM().toArray(MAX_LANEAREA_NUM);
		public byte                                byLaneType;
		public byte                                byUseageType;
		public byte                                byRelaLaneDirectionType;
		public byte                                byLowSpeedLimit;
		public byte                                byBigCarLowSpeedLimit;
		public byte                                byLowSpeedCapEn;
		public byte                                byEmergencyCapEn;
		public byte[]                              byRes = new byte[9];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byEnable", "byRelatedDriveWay", "wDistance", "wTrigDelayTime", "byTrigDelayDistance", "bySpeedCapEn", "bySignSpeed", "bySpeedLimit", "bySnapTimes", "byOverlayDriveWay", "struInterval", "byRelatedIOOut", "byFlashMode", "byCartSignSpeed", "byCartSpeedLimit", "byRelatedIOOutEx", "struPlateRecog", "byLaneType", "byUseageType", "byRelaLaneDirectionType", "byLowSpeedLimit", "byBigCarLowSpeedLimit", "byLowSpeedCapEn", "byEmergencyCapEn", "byRes");
		}
	}

	public static class NET_ITC_POST_RS485_RADAR_PARAM extends Structure{
		public byte                          byRelatedLaneNum;
		public byte[]                        byRes1 = new byte[3];
		public NET_ITC_PLATE_RECOG_PARAM     struPlateRecog = new NET_ITC_PLATE_RECOG_PARAM();
		public NET_ITC_LANE_PARAM[]          struLane = (NET_ITC_LANE_PARAM[])new NET_ITC_LANE_PARAM().toArray(MAX_ITC_LANE_NUM);
		public NET_ITC_RADAR_PARAM           struRadar = new NET_ITC_RADAR_PARAM();
		public byte[]                        byRes = new byte[32];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byRelatedLaneNum", "byRes1", "struPlateRecog", "struLane", "struRadar", "byRes");
		}
	}

	public static class NET_ITC_TRIGGER_PARAM_UNION extends Union{
		public int[]                              uLen = new int[1070];
		public NET_ITC_POST_RS485_RADAR_PARAM     struPostRadar = new NET_ITC_POST_RS485_RADAR_PARAM();
	}

	public static class NET_ITC_SINGLE_TRIGGERCFG extends Structure{
		public byte                            byEnable;
		public byte[]                          byRes1 = new byte[3];
		public int                             dwTriggerType;
		public NET_ITC_TRIGGER_PARAM_UNION     uTriggerParam = new NET_ITC_TRIGGER_PARAM_UNION();
		public byte[]                          byRes = new byte[64];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("byEnable", "byRes1", "dwTriggerType", "uTriggerParam", "byRes");
		}
	}

	public static class NET_ITC_TRIGGERCFG extends Structure{
		public int                           dwSize;
		public NET_ITC_SINGLE_TRIGGERCFG     struTriggerParam = new NET_ITC_SINGLE_TRIGGERCFG();
		public byte[]                        byRes = new byte[32];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "struTriggerParam", "byRes");
		}
	}

	public static class NET_DVR_SHOWSTRINGINFO extends Structure{
		public short      wShowString;
		public short      wStringSize;
		public short      wShowStringTopLeftX;
		public short      wShowStringTopLeftY;
		public byte[]     sString = new byte[44];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("wShowString", "wStringSize", "wShowStringTopLeftX", "wShowStringTopLeftY", "sString");
		}
	}

	public static class NET_DVR_SHOWSTRING_V30 extends Structure{
		public int                       dwSize;
		public NET_DVR_SHOWSTRINGINFO[]  struStringInfo = (NET_DVR_SHOWSTRINGINFO[])new NET_DVR_SHOWSTRINGINFO().toArray(MAX_STRINGNUM_V30);

		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "struStringInfo");
		}
	}

	public static class NET_DVR_FIND_PICTURE_PARAM extends Structure{
		public int             dwSize;
		public int             lChannel;
		public byte            byFileType;
		public byte            byNeedCard;
		public byte            byProvince;
		public byte            byRes1;
		public byte[]          sCardNum = new byte[CARDNUM_LEN_V30];
		public NET_DVR_TIME    struStartTime = new NET_DVR_TIME();
		public NET_DVR_TIME    struStopTime = new NET_DVR_TIME();
		public int             dwTrafficType;
		public int             dwVehicleType;
		public int             dwIllegalType;
		public byte            byLaneNo;
		public byte            bySubHvtType;
		public byte[]          byRes2 = new byte[2];
		public byte[]          sLicense = new byte[MAX_LICENSE_LEN];
		public byte            byRegion;
		public byte            byCountry;
		public byte[]          byRes3 = new byte[6];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("dwSize", "lChannel", "byFileType", "byNeedCard", "byProvince", "byRes1", "sCardNum", "struStartTime", "struStopTime", "dwTrafficType", "dwVehicleType", "dwIllegalType", "byLaneNo", "bySubHvtType", "byRes2", "sLicense", "byRegion", "byCountry", "byRes3");
		}
	}

	public static class NET_DVR_FACE_EXTRA_INFO extends Structure{
		public NET_VCA_RECT[] struVcaRect = (NET_VCA_RECT[])new NET_VCA_RECT().toArray(MAX_FACE_PIC_NUM);
		public byte[]         byRes = new byte[64];
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("struVcaRect", "byRes");
		}
	}

	public static class NET_DVR_PIC_EXTRA_INFO_UNION extends Union{
		public byte[]   byUnionLen = new byte[544];
		public          NET_DVR_FACE_EXTRA_INFO   struFaceExtraInfo = new NET_DVR_FACE_EXTRA_INFO();
	}

	public static class NET_DVR_FIND_PICTURE_V40 extends Structure{
		public byte[]                           sFileName = new byte[PICTURE_NAME_LEN];
		public NET_DVR_TIME                     struTime = new NET_DVR_TIME();
		public int                              dwFileSize;
		public byte[]                           sCardNum = new byte[CARDNUM_LEN_V30];
		public byte                             byPlateColor;
		public byte                             byVehicleLogo;
		public byte                             byFileType;
		public byte                             byRecogResult ;
		public byte[]                           sLicense = new byte[MAX_LICENSE_LEN];
		public byte                             byEventSearchStatus;
		public byte[]                           byRes = new byte[75];
		public NET_DVR_PIC_EXTRA_INFO_UNION     uPicExtraInfo = new NET_DVR_PIC_EXTRA_INFO_UNION();
		@Override
		protected List<String> getFieldOrder() {
			// TODO Auto-generated method stub
			return Arrays.asList("sFileName", "struTime", "dwFileSize", "sCardNum","byPlateColor", "byVehicleLogo","byFileType", "byRecogResult", "sLicense", "byEventSearchStatus", "byRes", "uPicExtraInfo");
		}
	}

	int NET_DVR_GetSDKVersion();
	int NET_DVR_GetLastError();
	int NET_DVR_Login_V40(Pointer pLoginInfo, Pointer lpDevice);
	boolean NET_DVR_RestoreConfig(int lUserID);
	boolean NET_DVR_ControlGateway(int lUserID, int lGatewayIndex, int dwStaic);
	boolean NET_DVR_RemoteControl(int lUserID, int dwCommand, Pointer lpInBuffer, int dwInBufferSize);
	boolean NET_DVR_Logout(int lUserID);
	boolean NET_DVR_STDXMLConfig(int lUserID, NET_DVR_XML_CONFIG_INPUT lpInputParam, NET_DVR_XML_CONFIG_OUTPUT lpOutputParam);
	boolean NET_DVR_GetDVRConfig(int lUserID, int dwCommand, int lChannel, Pointer lpOutBuffer, int dwOutBufferSize, IntByReference lpBytesReturned);
	boolean NET_DVR_SetDVRConfig(int lUserID, int dwCommand, int lChannel, Pointer lpInBuffer, int dwInBufferSize);
	boolean NET_DVR_GetDeviceConfig(int lUserID, int dwCommand, int dwCount, Pointer lpInBuffer, int dwInBufferSize, Pointer lpStatusList, Pointer lpOutBuffer, int dwOutBuggerSize);
	boolean NET_DVR_SetDeviceConfig(int lUserID, int dwCommand, int dwCount, Pointer lpInBuffer, int dwInBufferSize, Pointer lpStatusList, Pointer lpInParamBuffer, int dwInParamBufferSize);
	boolean NET_DVR_GetSTDConfig(int lUserID, int dwCommand, Pointer lpConfigParam);
	boolean NET_DVR_SetSTDConfig(int lUserID, int dwCommand, Pointer lpConfigParam);
	boolean NET_DVR_GetSTDAbility(int lUserID, int dwAbilityType, Pointer lpAbilityParam);
	boolean NET_DVR_SetDVRMessageCallBack_V30(FMSGCallBack fMessageCallBack, Pointer pUser);
	boolean NET_DVR_SetDVRMessageCallBack_V50(int iIndex, FMSGCallBack fMessageCallBack, Pointer pUser);
	int NET_DVR_SetupAlarmChan_V30(int lUserID);
	int NET_DVR_SetupAlarmChan_V41(int lUserID, Pointer lpSetupParam);
	boolean NET_DVR_CloseAlarmChan_V30(int lAlarmHandle);
	int NET_DVR_StartRemoteConfig(int lUserID, int dwCommand, Pointer lpInBuffer, int dwInBufferLen, fRemoteConfigCallback cbStateCallback, Pointer pUserData);
	boolean NET_DVR_SendRemoteConfig(int lHandle, int dwDataType, Pointer pSendBuf, int dwBufSize);
	boolean NET_DVR_StopRemoteConfig(int lHandle);
	int NET_DVR_MatrixStartPassiveDecode(int lUserID, int dwDecChanNum, Pointer lpPassiveMode);
	boolean NET_DVR_MatrixSendData(int lPassiveHandle, Pointer pSendBuf, int dwBufSize);
	boolean NET_DVR_MatrixStopPassiveDecode(int lPassiveHandle);
	int NET_DVR_MatrixGetPassiveDecodeStatus(int lPassiveHandle);
	int NET_DVR_UploadFile_V40(int lUserID, int dwUploadType, Pointer lpInBuffer, int dwInBufferLen, String sFileName, Pointer lpOutBuffer, int dwOutBufferLen);
	int NET_DVR_UploadSend(int lUploadHandle, Pointer pstruSendParamIN, Pointer lpOutBuffer);
	int NET_DVR_GetUploadState(int lUploadHandle, IntByReference pProgress);
	boolean NET_DVR_GetUploadResult(int lUploadHandle, Pointer lpOutBuffer, int dwOutBufferSize);
	boolean NET_DVR_UploadClose(int lUploadHandle);

	int NET_DVR_CreateOpenEzvizUser(Pointer pLoginInfo, Pointer pDeviceInfo);
	//int NET_DVR_CreateOpenEzvizUser(NET_DVR_OPEN_EZVIZ_USER_LOGIN_INFO pLoginInfo, NET_DVR_DEVICEINFO_V40 pDeviceInfo);
	boolean NET_DVR_DeleteOpenEzvizUser(int iUserID);

	boolean NET_DVR_GetInputSignalList_V40(int lUserID, int dwDevNum, NET_DVR_INPUT_SIGNAL_LIST lpInputSignalList);

//	int NET_DVR_RealPlay_V40(int lUserID,NET_DVR_PREVIEWINFO lpPreviewInfo,FRealDataCallBack_V30 fRealDataCall,Pointer pUser );
//	 boolean  NET_DVR_StopRealPlay(int lRealHandle);

	boolean NET_DVR_OpenSound(int lRealHandle);
	boolean NET_DVR_CloseSound();
	boolean NET_DVR_Volume(int lRealHandle, short wVolume);


	public interface FMSGCallBack extends Callback {
		public void invoke(int lCommand, NET_DVR_ALARMER pAlarmer,
						   Pointer pAlarmInfo, int dwBufLen, Pointer pUser);
	}

	public interface fRemoteConfigCallback extends Callback {
		public void invoke(int dwType, Pointer lpBuffer, int dwBufLen,
						   Pointer pUserData);
	}

	public interface FLoginResultCallBack extends Callback{
		public int invoke(int lUserID, int dwResult, NET_DVR_DEVICEINFO_V30 lpDeviceinfo, Pointer pUser);
	}

	int NET_DVR_FindPicture(int lUserID, Pointer pFindParam);
	int NET_DVR_FindNextPicture_V40(int lFindHandle, Pointer lpFindData);
	boolean NET_DVR_CloseFindPicture(int lFindHandle);
	boolean NET_DVR_GetPicture_V30(int lUserID, Pointer sDVRFileName, Pointer sSavedFileBuf, int dwBufLen, IntByReference lpdwRetLen);

//	public interface FRealDataCallBack_V30 extends Callback{
//		public void invoke(int lRealHandle, int dwDataType,
//                ByteByReference pBuffer, int dwBufSize, Pointer pUser);
//    }

	int NET_DVR_GetRealPlayerIndex(int lRealHandle);
	int NET_DVR_GetPlayBackPlayerIndex(int lPlayHandle);

	boolean NET_DVR_SetCapturePictureMode(int dwCaptureMode);
	boolean NET_DVR_CapturePictureBlock(int iRealHandle, String sPicFileName, int dwTimeOut);
	boolean NET_DVR_CapturePicture(int iRealHandle, String sPicFileName);
	boolean NET_DVR_PlayBackCaptureFile(int lPlayHandle, String sFileName);

	boolean NET_DVR_SaveRealData_V30(int lRealHandle, int dwTransType, String sFileName);
}