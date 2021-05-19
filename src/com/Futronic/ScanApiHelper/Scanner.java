package Futronic.ScanApiHelper;

/**
 *
 * @author slyeung
 */
public class Scanner {
    public native boolean OpenDevice();
    public native boolean CloseDevice();
    public native String GetVersionInfo();
    public native boolean GetImageSize();
    public native boolean IsFingerPresent();
    public native boolean GetFrame(byte[] pImage);
    public native boolean GetImage2(int nDose, byte[] pImage);
    public native boolean SetOptions(int Mask, int Flag);
    public native int GetLastErrorCode();
    public native boolean Save7Bytes(byte[] buffer);
    public native boolean Restore7Bytes(byte[] buffer);
    public native boolean SetNewAuthorizationCode(byte[] SevenBytesAuthorizationCode);
    public native boolean SaveSecret7Bytes(byte[] SevenBytesAuthorizationCode, byte[] buffer);
    public native boolean RestoreSecret7Bytes(byte[] SevenBytesAuthorizationCode, byte[] buffer);
    public native boolean SetDiodesStatus(int GreenDiodeStatus, int RedDiodeStatus );
    public native boolean GetDiodesStatus( byte[] Status ); //2 bytes - 1st:Green, 2nd:Red
    // options
    public final int FTR_ERROR_NO_ERROR = 0;
    public final int FTR_OPTIONS_CHECK_FAKE_REPLICA = 0x00000001;
    public final int FTR_OPTIONS_DETECT_FAKE_FINGER = FTR_OPTIONS_CHECK_FAKE_REPLICA;
    public final int FTR_OPTIONS_IMPROVE_IMAGE = 0x00000020; // for PIV compatible devices
    public final int FTR_OPTIONS_INVERT_IMAGE = 0x00000040;
    // error code
    public final int FTR_ERROR_EMPTY_FRAME = 4306; /* ERROR_EMPTY */
    public final int FTR_ERROR_MOVABLE_FINGER = 0x20000001;
    public final int FTR_ERROR_NO_FRAME = 0x20000002;
    public final int FTR_ERROR_HARDWARE_INCOMPATIBLE = 0x20000004;
    public final int FTR_ERROR_FIRMWARE_INCOMPATIBLE = 0x20000005;
    public final int FTR_ERROR_INVALID_AUTHORIZATION_CODE = 0x20000006;
    public final int FTR_ERROR_WRITE_PROTECT = 19;

    public int GetImageWidth()
    {
        return m_ImageWidth;
    }
    public int GetImaegHeight()
    {
        return m_ImageHeight;
    }

    public String GetErrorMessage()
    {
        int errcode = GetLastErrorCode();
        String strErrMsg;
        switch(errcode)
        {
            case FTR_ERROR_NO_ERROR:
                strErrMsg = "OK";
                break;
            case FTR_ERROR_EMPTY_FRAME:
                strErrMsg = "Empty Frame";
                break;
            case FTR_ERROR_MOVABLE_FINGER:
                strErrMsg = "Moveable Fingerprint";
                break;
            case FTR_ERROR_NO_FRAME:
                strErrMsg = "Fake Fingerprint";
                break;
            case FTR_ERROR_HARDWARE_INCOMPATIBLE:
                strErrMsg = "Hardware Incompatible";
                break;
            case FTR_ERROR_FIRMWARE_INCOMPATIBLE:
                strErrMsg = "Firmware Incompatible";
                break;
            case FTR_ERROR_INVALID_AUTHORIZATION_CODE:
                strErrMsg = "Invalid Authorization Code";
                break;
            case FTR_ERROR_WRITE_PROTECT:
                strErrMsg = "Write Protect";
                break;
            default:
                strErrMsg = String.format("Error code is %d", errcode);
                break;
        }
        return strErrMsg;
    }

    static {
        System.loadLibrary("ftrJavaScanAPI");
    }

    private int m_ImageWidth;
    private int m_ImageHeight;
}

