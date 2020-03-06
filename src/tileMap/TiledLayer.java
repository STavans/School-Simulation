package tileMap;


import javax.json.JsonObject;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TiledLayer {
    private int width;
    private int height;
    private String name;
    private int [][] map;
    private double opacity;
    private boolean visible;


    public TiledLayer(JsonObject jsonData) {

        this.width = jsonData.getInt("width");
        this.height = jsonData.getInt("height");

        this.name = jsonData.getString("name");
        this.opacity = jsonData.getJsonNumber("opacity").doubleValue();
        this.visible = jsonData.getBoolean("visible");


        map = new int[height][width];
        int i = 0;
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                map[y][x] = jsonData.getJsonArray("data").getInt(i);
                i++;
            }
        }


    }

    public void draw(Graphics2D g, ArrayList<BufferedImage> tiles)
    {
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                if(map[y][x] == 0)
                    continue;
                g.drawImage(
                        tiles.get(map[y][x]),
                        AffineTransform.getTranslateInstance(x*32, y*32),
                        null);
            }
        }
    }


}
