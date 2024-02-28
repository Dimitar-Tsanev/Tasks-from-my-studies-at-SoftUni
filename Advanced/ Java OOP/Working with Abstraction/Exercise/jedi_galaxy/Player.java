package jedi_galaxy;

class Player {
    private int playerRow;
    private int playerCol;
    private long sumOfResources;
    public void setPlayerCoordinates ( int... coordinates) {
        int row = coordinates[0];
        int col = coordinates[1];

        this.setRow ( row );
        this.setCol ( col );

    }
    public int getRow () {
        return playerRow;
    }
    public int getCol () {
        return playerCol;
    }
    public long getSumOfResources () {
        return sumOfResources;
    }
    private void setRow ( int row ) {
        this.playerRow = row;
    }
    private void setCol ( int startingCol ) {
        this.playerCol = startingCol;
    }
    public void addResources (int cell) {
        this.sumOfResources += cell;
    }
    public void movePlayer(){
        this.setRow ( getRow () - 1 );
        this.setCol ( getCol () + 1 );
    }
}
