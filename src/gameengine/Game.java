package gameengine;

import BattleShip.BattleShipConstants;
import java.util.HashMap;
import java.util.Map;
import javafx.animation.KeyValue;

public abstract class Game implements IGame
{
    protected Attack attack;
    protected Map<String, Object> GameSettings;
    public Object GetSetting(String key)
    {
        return GameSettings.get(key);
    }
    public void SetSetting(String key, Object value)
    {
        GameSettings.put(key, value);
    }
    public Game(HashMap<String, Object> settings)
    {
        GameSettings = new HashMap<>();
        for (Map.Entry<String, Object> kvp : settings.entrySet())
            GameSettings.put(kvp.getKey(), kvp.getValue());
    }
}
