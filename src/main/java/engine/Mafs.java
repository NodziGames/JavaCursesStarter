package engine;

public class Mafs {
    //A class with extended Maths functions aimed specifically at game development

    public static int random_range_int(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    public static float random_range_float(float min, float max) {
        return min + (float)(Math.random() * ((max - min) + 1));
    }

    public static double random_range_double(double min, double max) {
        return min + (double)(Math.random() * ((max - min) + 1));
    }
}
