package milkyway.SaveableSerializing.Java8.Collections.List;

import milkyway.SaveableSerializing.Java8.API.GenericsResolver;
import milkyway.SaveableSerializing.Java8.Collections.SaveableCollection;
import milkyway.SaveableSerializing.Java8.Exceptions.CollectionsNullException;
import milkyway.SaveableSerializing.Java8.Exceptions.TypeNotSupportedException;
import milkyway.SaveableSerializing.Parser.NullSaveableData;
import milkyway.SaveableSerializing.Parser.SaveableData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-05-11.
 */
public abstract class SaveableList implements SaveableData,SaveableCollection{
    private GenericsResolver.ItemType type = GenericsResolver.ItemType.Empty;
    private List<Object> list = new ArrayList<>();

    @Override
    public GenericsResolver.ItemType[] getGenericsType() {
        return new GenericsResolver.ItemType[]{type};
    }

    public SaveableList(List list) throws CollectionsNullException,TypeNotSupportedException{
        type = GenericsResolver.resolveGenerics(list);
        for(Object a : list)
            this.list.add(a);
    }
    public SaveableList(String listType){
        switch (listType){
            case "LinkedList":
                this.list = new LinkedList<>();
                break;
            case "ArrayList":
                this.list = new ArrayList<>();
                break;
        }
    }

    public SaveableList(List list,String listType) throws CollectionsNullException,TypeNotSupportedException{
        switch (listType){
            case "LinkedList":
                this.list = new LinkedList<>();
                break;
            case "ArrayList":
                this.list = new ArrayList<>();
                break;
        }
        type = GenericsResolver.resolveGenerics(list);
        for(Object a : list)
            this.list.add(a);
    }
    public GenericsResolver.ItemType getGenerics() {
        return type;
    }


    public int size() {
        return list.size();
    }


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


    public boolean remove(Object obj) {
        return list.remove((Object)obj);
    }


    public Object remove(int obj) {
        return list.remove(obj);
    }

    public boolean contains(Object obj) {
        return list.contains(obj);
    }


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
        for(int i = 1;i < builded.size();i++)
        {
            String n = builded.get(i).substring(1);
            if(n.equals("SaveableNxNullPointerItemObject")){
                list.add(null);
                continue;
            }
            if(type.getResolver().canResolve(n))
                list.add(type.getResolver().resolve(n));
        }
        finalizeObject();
    }


    List<SaveableData> temp = new ArrayList<>();
    @Override
    public void appendObject(String str, SaveableData data) {
        if(str.equals("NullPointer"))
            temp.add(null);
        else
            temp.add(data);
    }

    @Override
    public Object getOriginal() {
        return list;
    }


    @Override
    public boolean finalizeObject() {
        if(type == GenericsResolver.ItemType.Saveable)
            for(SaveableData dat : temp)
                list.add(dat);
        temp.clear();
        return false;
    }
}
