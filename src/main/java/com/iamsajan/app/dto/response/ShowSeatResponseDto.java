package com.iamsajan.app.dto.response;

import com.iamsajan.app.model.Booking;
import com.iamsajan.app.model.CinemaSeat;
import com.iamsajan.app.model.Show;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShowSeatResponseDto {
    private String Id;
    private int status;
    private Number price;
    private Show show;
    private Booking booking;
    private CinemaSeat cinemaSeat;
}
