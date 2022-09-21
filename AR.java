import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.calib3d.Calib3d;

public class AR {
    public static void main(String args[]) {
        
        System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

        //Instantiating the Imagecodecs class
        Imgcodecs imageCodecs = new Imgcodecs();

        //Reading the Image from the file
        String file ="F:\\ArucoJava\\src\\AR.png";// Your iamage location
        Mat framein= imageCodecs.imread(file);
        Mat frameout= new Mat();
        double[] l1 = { 523.105750, 0.000000, 635.434258,0.000000, 534.765913, 500.335102,0.000000, 0.000000, 1.000000};
        double[] l2 = { -0.164787, 0.020375, -0.001572, -0.000369, 0.000000};
        Mat cam= new Mat(3, 3, CvType.CV_32FC1); ;

        cam.put(0,0,l1);
        Mat coeff = new Mat(1, 5, CvType.CV_32FC1);

        coeff.put(0,0,l2);

        Calib3d.undistort(framein,frameout,cam,coeff);
        imageCodecs.imwrite("F:\\ArucoJava\\src\\Aruco1.png",frameout);
        
        

    }
}
//Create a mat object with cv type cv32fc1
