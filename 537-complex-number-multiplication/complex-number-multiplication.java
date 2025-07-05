class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int[] complex1 = parseComplex(num1);
        int real1 = complex1[0];    
        int img1 = complex1[1];     

        int[] complex2 = parseComplex(num2);
        int real2 = complex2[0];    
        int img2 = complex2[1];

        int realPart = (real1 * real2) - (img1 * img2);
        int imgPart = (real1 * img2) + (real2 * img1);

        return realPart + "+" + imgPart + "i";
        
    }
    private static int[] parseComplex(String complex) {
        complex = complex.replace("i", "");
        String[] parts = complex.split("\\+"); 
        int real = Integer.parseInt(parts[0]); 
        int imaginary = Integer.parseInt(parts[1]); 
        return new int[]{real, imaginary};
    }
}