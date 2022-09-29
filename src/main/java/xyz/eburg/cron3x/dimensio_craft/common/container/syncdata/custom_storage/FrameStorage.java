package xyz.eburg.cron3x.dimensio_craft.common.container.syncdata.custom_storage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FrameStorage implements Serializable{
    public static List<BlockEntity> convBytes2List(byte[] bytes) {
        String str = new String(bytes, StandardCharsets.UTF_8);
        Type listType = new TypeToken<List<BlockEntity>>() {}.getType();
        return new Gson().fromJson(str, listType);
    }
    public static byte[] convList2Bytes(List<BlockEntity> list) {
        return convList2Json(list).getBytes();
    }
    public static String convList2Json(List<BlockEntity> list){
        return  new Gson().toJson(list);
    }
}