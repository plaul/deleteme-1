package kea.dat22v2.mdd.eksamen3sem.app.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import kea.dat22v2.mdd.eksamen3sem.app.entity.Event;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EventRequest {

    private String name;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    private String description;

    private Integer capacity;




    public static Event getEventEntity(EventRequest request) {
        return Event.builder()
            .name(request.getName())
            .date(request.getDate())
            .description(request.getDescription())
            .capacity(request.getCapacity())
            .build();
    }

}