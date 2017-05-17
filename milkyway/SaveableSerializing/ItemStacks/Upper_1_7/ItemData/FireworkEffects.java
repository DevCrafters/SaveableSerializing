package milkyway.SaveableSerializing.ItemStacks.Upper_1_7.ItemData;


import milkyway.SaveableSerializing.ItemStacks.Upper_1_7.DataTypes.ListRGB;
import milkyway.SaveableSerializing.Parser.SaveableData;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-04-18.
 */
public class FireworkEffects implements SaveableData{
    private boolean isFlicker = false;
    private boolean trail  = false;
    private ListRGB main = null;
    private ListRGB fade = null;
    private String fireworkType = FireworkEffect.Type.BALL.name();
    public FireworkEffects(){}
    public FireworkEffects(FireworkEffect effect){
        if(effect != null){
            main = new ListRGB(effect.getColors());
            fade = new ListRGB(effect.getFadeColors());
            trail = effect.hasTrail();
            isFlicker = effect.hasFlicker();
            fireworkType = effect.getType().name();
        }else{
            main = new ListRGB(new ArrayList<>());
            fade = new ListRGB(new ArrayList<>());
        }
    }
    @Override
    public void writeBy(StringBuilder builder) {
        builder.append(String.valueOf(isFlicker)).append("\n");
        builder.append(String.valueOf(trail)).append("\n");
        builder.append(fireworkType).append("\n");
        main.appendSubSet(builder);
        fade.appendSubSet(builder);
    }

    @Override
    public void appendTo(List<String> builded) {
        try{
            isFlicker = Boolean.parseBoolean(builded.get(0));
            trail = Boolean.parseBoolean(builded.get(1));
            fireworkType = builded.get(2);
        }catch (Exception ex){}
    }

    @Override
    public String getName() {
        return "FireworkEffect";
    }

    @Override
    public void appendObject(String str, SaveableData data) {
        if(data instanceof ListRGB){
            if(main == null)
                main = (ListRGB) data;
            else
                fade = (ListRGB) data;
        }
    }

    @Override
    public Object getOriginal() {
        FireworkEffect.Type t =  FireworkEffect.Type.BALL;
        try{
            t = FireworkEffect.Type.valueOf(fireworkType);
        }catch (Exception ex){}
        if(((List<Color>)main.getOriginal()).size() >= 1)
         return FireworkEffect.builder().with(t).flicker(isFlicker).trail(trail).withColor((List<Color>)main.getOriginal()).withFade((List<Color>)fade.getOriginal()).build();
        return null;
    }

    @Override
    public SaveableData getNewInstance() {
        return new FireworkEffects();
    }
}
