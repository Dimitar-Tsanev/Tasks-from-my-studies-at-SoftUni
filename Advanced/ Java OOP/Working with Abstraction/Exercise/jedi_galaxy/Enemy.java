package jedi_galaxy;

class Enemy {
    private int enemyRow;
    private int enemyCol;
    public Enemy (int... coordinates  ) {
        int row = coordinates[0];
        int col = coordinates[1];

        this.setRow ( row );
        this.setCol ( col );

    }
    public int getRow () {
        return enemyRow;
    }
    public int getCol () {
        return enemyCol;
    }
    private void setRow ( int row ) {
        this.enemyRow = row;
    }
    private void setCol ( int col ) {
        this.enemyCol = col;
    }
    public void moveEnemy (){
        this.setRow ( getRow () - 1 );
        this.setCol ( getCol () - 1 );
    }
}
