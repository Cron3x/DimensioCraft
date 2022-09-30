package xyz.eburg.cron3x.dimensio_craft.common.container.syncdata.custom_storage;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import net.minecraft.world.level.block.entity.BlockEntity;
import xyz.eburg.cron3x.dimensio_craft.DimensioCraft;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FrameStorage implements Serializable{

    /* JSON:
     *
     *   PosX
     *   PosY
     *   PosZ
     *   Level
     */

    public static String bytes2string(byte[] bytes){

        return "";
    }

    public static void list2Json(List<BlockEntity> list){

        Gson gson = new Gson();
        String json = gson.toJson(list);
        DimensioCraft.LOGGER.debug(json);
    }
}