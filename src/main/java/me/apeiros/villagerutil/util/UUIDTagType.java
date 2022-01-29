package me.apeiros.villagerutil.util;

import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import java.nio.ByteBuffer;
import java.util.UUID;

public class UUIDTagType implements PersistentDataType<byte[], UUID> {

    @Override
    public @Nonnull
    Class<byte[]> getPrimitiveType() {
        return byte[].class;
    }

    @Override
    public @Nonnull
    Class<UUID> getComplexType() {
        return UUID.class;
    }

    @Override
    public @Nonnull
    byte[] toPrimitive(UUID complex, @Nonnull PersistentDataAdapterContext context) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(complex.getMostSignificantBits());
        bb.putLong(complex.getLeastSignificantBits());
        return bb.array();
    }

    @Override
    public @Nonnull
    UUID fromPrimitive(@Nonnull byte[] primitive, @Nonnull PersistentDataAdapterContext context) {
        ByteBuffer bb = ByteBuffer.wrap(primitive);
        long firstLong = bb.getLong();
        long secondLong = bb.getLong();
        return new UUID(firstLong, secondLong);
    }

}