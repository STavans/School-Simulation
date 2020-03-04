import javax.imageio.ImageIO;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;


public class TiledMap {
	private int width;
	private int height;

	private int tileHeight;
	private int tileWidth;

	private ArrayList<BufferedImage> tiles = new ArrayList<>();

    private ArrayList<TiledLayer> layers = new ArrayList<>();

	public TiledMap(String fileName)
	{
		JsonReader reader = null;
		reader = Json.createReader(getClass().getResourceAsStream(fileName));
		JsonObject root = reader.readObject();

		this.width = root.getInt("width");
		this.height = root.getInt("height");

        JsonArray tilesets = root.getJsonArray("tilesets");

        for(int i = 0; i < tilesets.size(); i++) {
            //load the tilemap
            try {
                JsonObject tileset = tilesets.getJsonObject(i);

                BufferedImage tilemap = ImageIO.read(getClass().getResourceAsStream(tileset.getString("image")));

                tileHeight = tileset.getInt("tileheight");
                tileWidth = tileset.getInt("tilewidth");
                int gid = tileset.getInt("firstgid");
                int tileCount = tileset.getInt("tilecount");

                //er voor zorgen dat tiles gid+tileCount elementen groot is
                while(tiles.size() < gid + tileCount) {
                    tiles.add(null);
                }


                for (int y = 0; y < tilemap.getHeight(); y += tileHeight) {
                    for (int x = 0; x < tilemap.getWidth(); x += tileWidth) {
                        tiles.set(gid, tilemap.getSubimage(x, y, tileWidth, tileHeight));

                        gid++;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JsonArray layers = root.getJsonArray("layers");


        for(int i = 0; i < layers.size(); i++) {
			JsonObject layerInfo = layers.getJsonObject(i);
			if(layerInfo.getString("type").equals("tilelayer")) {
				this.layers.add(new TiledLayer(layerInfo));
			}
		}


	}

	void draw(Graphics2D g2d)
	{

		for(TiledLayer layer : this.layers) {
			layer.draw(g2d, tiles);
		}


	}

}
