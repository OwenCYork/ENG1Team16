package com.mygdx.game.Board;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Map{

    public int[][] mapGrid;
    TiledMap tiledMap;
    OrthogonalTiledMapRenderer tiledMapRenderer;


    public int getAt(int x, int y){
        return mapGrid[y][x];
    }


    /**
     * Loads the .tmx file of the map
     */
    public Map(){
        tiledMap = new TmxMapLoader().load("Eng1Map.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
    }

    /**
     * Renders the map and sets the camera to view the map
     */
    public void render(OrthographicCamera camera){
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
    }

    /**
     * Given the coordinate of the tile in terms of row and column
     * @param row The position in the row of tiles counted from the left
     * @param col The position in the column of tiles counted from bottom
     * @param layer The layer in which the tiles is found. layer = 0 for all tiles
     * @return TileType for the specific row and column
     */
    public TileType getTileTypebyCoordinate(int layer, int col, int row){
        TiledMapTileLayer.Cell cell = ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getCell(col,row);
        if (cell!=null){
            TiledMapTile tile = cell.getTile();
            if (tile!= null){
                int id = tile.getId();
                return TileType.getTileTypebyid(id);
            }
        }
        return null;
    }
    /**
     * Returns Width of map
     * @return The number of tiles located in the row
     */
    public int getWidth(){
        return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getWidth();
    }
    /**
     * Returns Height of map
     * @return The number of tiles located in the column
     */
    public int getHeight(){
        return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getHeight();
    }
    /**
     * Given the x,y coordinate within the camera space return tiletype
     * @param x  The x coordinate of tile of which the type is wanted
     * @param y  The y coordinate of tile of which the type is wanted
     * @param layer The layer of tile of which the type is wanted, 0 = all tiles
     * @return Tiletype of tile located at x,y
     */
    public TileType getTileTypebyLoc(int layer, float x, float y) {
        return this.getTileTypebyCoordinate(layer,(int) (x / TileType.TileSize), (int) (y / TileType.TileSize));
    }
}

