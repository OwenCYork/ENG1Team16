public class Main{
    protected Tasks[] tasks;
    protected Player playerOne;
    protected Enemy[] enemies;
    protected Map gameMap;
    protected int points;
    public Main(){
        this.SetupGraphics();
        this.tasks = this.SetupTasks();
        this.playerOne = new Player();//Player start data
        this.enemies = this.SetupEnemys();
        this.gameMap = this.CreateMap();
        this.points = 0;
    }

    private void SetupGraphics(){
        //Set up LIBGDX
    }

    private Tasks[] SetupTasks(){
        Tasks[] data = {new Tasks()};
        // Setup the Tasks
        return(data);
    }


    private Enemy[] SetupEnemys(){
        Enemy[] data = {new Enemy()};
        // Setup the Enemys
        return(data);
    }

    private Map CreateMap(){
        Map map = new Map();
        // Initialise the map
        return(map);
    }

    private void draw(int[] data){
        //[x,y,width,height] so far
    }

    public void draw(){
        int[] data;
        
        data = this.gameMap.draw();
        this.draw(data);

        for(int index=0;index<this.tasks.length;index++){
            data = this.tasks[index].draw();
            this.draw(data);
        };

        for(int index=0;index<this.enemies.length;index++){
            data = this.enemies[index].draw();
            this.draw(data);
        };

        data = this.playerOne.draw();
        this.draw(data);

    }

}