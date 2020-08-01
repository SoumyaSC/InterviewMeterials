package Algorithms;

/*Count the number of segments in a string,
        where a segment is defined to be a contiguous sequence of non-space characters.*/
public class SegmentsOfString {
    public int countSegments(String s) {
        int result = 0;

        if(s.equals("")){
            return result;
        }
        String []splitStrArray = s.split(" ");
        result = splitStrArray.length;

        return result;
    }
}
