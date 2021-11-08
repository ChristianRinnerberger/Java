public class Main {
    public static void main(String[] args) {
        Camera cam = new Camera(null, "brand", 23,23,false);
        Lens lens = new Lens(1000, 1500);
        Lens lens1 = new Lens(1, 1);
        Lens lens2 = new Lens(2, 2);
        Camera camera = new Camera(lens, "brand", 500,12,true);
        Camera camera1 = new Camera(lens2, "brand", 1000, 14, true);
        Camera camera2 = new Camera(lens1, "Brand", 1, 1, false);


        System.out.println(camera.isColored());
        System.out.println(Camera.count);
        System.out.println(camera);
        System.out.println(camera1);
        System.out.println(camera2);
        cam.setLens(lens1);
        System.out.println(cam);



    }
}
