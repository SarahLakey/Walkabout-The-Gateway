package org.launchcode.walkabout.models.dto;
import jakarta.validation.constraints.NotNull;
import java.awt.*;

public class ReportButtonDTO {

   @NotNull
   private final Button event;
   public Label reportButton;

    public ReportButtonDTO(){
       event = new Button("Report Here");
       event.setActionCommand();

    };

    public Event getEvent() {
        return event;
    }

    //public void setEvent(Event event) {
        //this.event = event;
    }
}
