package logic.image;

public class PixelUtil {
    
    public static int getRed(final int pixel) {
        return getter(pixel, 16);
    }

    public static int getGreen(final int pixel) {
        return getter(pixel, 8);
    }

    public static int getBlue(final int pixel) {
        return getter(pixel, 0);
    }

    private static int getter(final int pixel, final int shift) {
        switch (shift) {
            case 32: // alpha
                throw new RuntimeException("Case not implemented yet!");
            case 16: // red
            case 8:  // green
            case 0:  // blue
                break;

            default:
                throw new IllegalArgumentException("PixelUtil: Illegal shift (was = " + shift + ")!");
        }
        return (pixel >> shift) & 0xFF;
    }

    public static int getGrayValue(final int pixel) {
        final int red, green, blue;
        red = getRed(pixel);
        green = getGreen(pixel);
        blue = getBlue(pixel);
        return (int) (0.299 * red + 0.587 * green + 0.114 * blue);
    }
}
