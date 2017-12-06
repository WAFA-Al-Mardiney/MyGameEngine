package BattleShip;

public class BattleShipConstants
{
    public static final String RowsCountKey = "Rows count";
    public static final String ColumnsCountKey = "Columns count";
    public static final String CellWidthKey = "Cell width";
    public static final String CellHeightKey = "Cell height";
    public static final String RequiredShipsCountKey = "Required ships count";
    public static final String Player1NameKey = "Player 1 name";
    public static final String Player2NameKey = "Player 2 name";
    public static final String ComputerNameKey = "Computer name";
    public static final Ship[] ShipTypes = new Ship[]
    {
        new Ship(1, 2, ERotation.Unknown),
        new Ship(1, 3, ERotation.Unknown),
        new Ship(1, 4, ERotation.Unknown),
        new Ship(1, 5, ERotation.Unknown)
    };
    //Small
    public static final int SmallRowsCount = 5;
    public static final int SmallColumnsCount = 5;
    public static final int SmallCellWidth = 100;
    public static final int SmallCellHeight = 100;
    public static final int SmallRequiredShipsCount = 2;
    //Medium
    public static final int MediumRequiredShipsCount = 5;
    //Large
    public static final int LargeRowsCount = 10;
    public static final int LargeColumnsCount = 10;
    public static final int LargeCellWidth = 50;
    public static final int LargeCellHeight = 50;
    public static final int LargeRequiredShipsCount = 10;
}
