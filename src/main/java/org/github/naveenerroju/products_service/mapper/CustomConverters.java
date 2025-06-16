package org.github.naveenerroju.products_service.mapper;

import com.google.protobuf.Timestamp;
import org.bson.types.ObjectId;
import org.github.naveenerroju.products_service.entity.FlashSales;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

/**
 * Utility class providing custom type conversions for use with MapStruct mapping.
 *
 * <p>Why this class exists:
 * <ul>
 *   <li><strong>gRPC Protobuf Compatibility:</strong> Protobuf generates immutable message classes
 *       that use builders and special types like {@code google.protobuf.Timestamp}, which are not directly
 *       compatible with Java types like {@code java.util.Date}.</li>
 *   <li><strong>MongoDB Integration:</strong> MongoDB uses {@code org.bson.types.ObjectId} as the native
 *       identifier type, whereas Protobuf messages typically use {@code string} for IDs. Conversion is required
 *       between these types.</li>
 *   <li><strong>MapStruct Limitations:</strong> MapStruct cannot automatically map incompatible or complex types
 *       such as {@code ObjectId <-> String} or {@code Date <-> Timestamp}. It requires manually defined methods
 *       marked with {@code @Named} to resolve these conversions.</li>
 * </ul>
 *
 * <p>By centralizing all such type conversions in this class and referencing it via MapStruct’s {@code uses} parameter,
 * we keep the mapping logic clean, reusable, and modular.
 *
 * <p>Each method here is annotated with {@code @Named} to allow targeted usage in {@code @Mapping} annotations within the mapper interface.
 */
@Component
public class CustomConverters {

    @Named("objectIdToString")
    public String objectIdToString(ObjectId id) {
        return id != null ? id.toHexString() : null;
    }

    @Named("stringToObjectId")
    public ObjectId stringToObjectId(String id) {
        return id != null && !id.isBlank() ? new ObjectId(id) : null;
    }

    @Named("dateToTimestamp")
    public Timestamp dateToTimestamp(Date date) {
        if (date == null) return null;
        Instant instant = date.toInstant();
        return Timestamp.newBuilder()
                .setSeconds(instant.getEpochSecond())
                .setNanos(instant.getNano())
                .build();
    }

    @Named("timestampToDate")
    public Date timestampToDate(Timestamp timestamp) {
        if (timestamp == null) return null;
        return Date.from(Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos()));
    }

}
