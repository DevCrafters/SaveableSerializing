package milkyway.SaveableSerializing.Java8.Collections.List;

import milkyway.SaveableSerializing.Java8.API.GenericsResolver;
import milkyway.SaveableSerializing.Java8.Exceptions.CollectionsNullException;
import milkyway.SaveableSerializing.Java8.Exceptions.TypeNotSupportedException;
import milkyway.SaveableSerializing.Parser.NullSaveableData;
import milkyway.SaveableSerializing.Parser.SaveableData;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-05-11.
 */
public class SaveableLinkedList extends SaveableList{
    public SaveableLinkedList(List list) throws CollectionsNullException,TypeNotSupportedException {
        type = GenericsResolver.resolveGenerics(list);
        for(Object a : list)
            this.list.add(a);
    }
    public SaveableLinkedList(){}
    private GenericsResolver.ItemType type = GenericsResolver.ItemType.Empty;
    private List<Object> list = new LinkedList<>();
    @Override
    public GenericsResolver.ItemType getGenerics() {
        return type;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void add(Object object) throws TypeNotSupportedException {
        if(object == null)
            list.add(null);
        if(type == GenericsResolver.ItemType.Empty){
            type = GenericsResolver.resolve(object);
            list.add(object);
        }else{
            if(!type.getResolver().canResolve(object))
                throw new TypeNotSupportedException();
            list.add(object);
        }
    }
    @Override
    public void add(int index,Object object) throws TypeNotSupportedException {
        if(object == null)
            list.add(null);
        if(type == GenericsResolver.ItemType.Empty){
            type = GenericsResolver.resolve(object);
            list.add(index,object);
        }else{
            if(!type.getResolver().canResolve(object))
                throw new TypeNotSupportedException();
            list.add(index,object);
        }
    }

    @Override
    public boolean remove(Object obj) {
        return list.remove((Object)obj);
    }

    @Override
    public Object remove(int obj) {
        return list.remove(obj);
    }

    @Override
    public boolean contains(Object obj) {
        return list.contains(obj);
    }

    @Override
    public boolean set(int location, Object obj) throws TypeNotSupportedException {
        if(obj == null)
        {
            list.set(location,null);
            return true;
        }
        if(type == GenericsResolver.ItemType.Empty){
            type = GenericsResolver.resolve(obj);
            list.set(location,obj);
        }else{
            if(!type.getResolver().canResolve(obj))
                throw new TypeNotSupportedException();
            list.set(location,obj);
        }
        return true;
    }

    @Override
    public void writeBy(StringBuilder builder) {
        builder.append(type.name()).append("\n");
        if(type == GenericsResolver.ItemType.Saveable)
            for(Object a : list)
               if(a != null)
                   ((SaveableData)a).appendSubSet(builder);
                else
                    new NullSaveableData().appendSubSet(builder);
        else
            for(Object a : list)
                if(a != null)
                    builder.append("`").append(a.toString()).append("\n");
                else   builder.append("`").append("SaveableNxNullPointerItemObject").append("\n");
    }

    @Override
    public void appendTo(List<String> builded) {
        try{
            type = GenericsResolver.ItemType.valueOf(builded.get(0));
        }catch (Exception ex){
            type = GenericsResolver.ItemType.String;
        }
        switch (type){

            case String:
                for(int i = 1;i < builded.size();i++)
                    list.add(builded.get(i).substring(1));
                break;
            case Integer:
                for(int i = 1;i < builded.size();i++)
                    try{list.add(Integer.parseInt(builded.get(i).substring(1)));}catch(Exception ex){list.add(0);}
                break;
            case Double:
                for(int i = 1;i < builded.size();i++)
                    try{list.add(Double.parseDouble(builded.get(i).substring(1)));}catch(Exception ex){list.add(0d);}
                break;
            case Float:
                for(int i = 1;i < builded.size();i++)
                    try{list.add(Float.parseFloat(builded.get(i).substring(1)));}catch(Exception ex){list.add(0f);}
                break;
            case Byte:
                for(int i = 1;i < builded.size();i++)
                    try{list.add(Byte.parseByte(builded.get(i).substring(1)));}catch(Exception ex){list.add((byte)0);}
                break;
            case Saveable:
                break;
            case Empty:
                break;
        }
    }

    @Override
    public String getName() {
        return "Java8_SaveableLinkedList";
    }

    @Override
    public void appendObject(String str, SaveableData data) {
        if(type == GenericsResolver.ItemType.Saveable)
            list.add(data);
    }

    @Override
    public Object getOriginal() {
        return list;
    }

    @Override
    public SaveableData getNewInstance() {
        return new SaveableArrayList();
    }
}
