package kea.dat22v2.mdd.eksamen3sem.app.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import kea.dat22v2.mdd.eksamen3sem.app.entity.Event;
import kea.dat22v2.mdd.eksamen3sem.app.entity.EventStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventResponse {

    private Integer id;

    private String name;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    private String description;

    private Integer capacity;

    private EventStatus eventStatus;

    private Integer remainingCapacity;


    public EventResponse(Event entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.date = entity.getDate();
        this.description = entity.getDescription();
        this.eventStatus = entity.getEventStatus();
    }
    public EventResponse(Event entity, boolean includeAll) {
        if (includeAll) {
            this.capacity = entity.getCapacity();
        }
        this.id = entity.getId();
        this.name = entity.getName();
        this.date = entity.getDate();
        this.description = entity.getDescription();
        this.eventStatus = entity.getEventStatus();
    }

}
