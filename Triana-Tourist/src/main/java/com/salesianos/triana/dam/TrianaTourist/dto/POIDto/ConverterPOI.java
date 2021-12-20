package com.salesianos.triana.dam.TrianaTourist.dto.POIDto;
import com.salesianos.triana.dam.TrianaTourist.models.POI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConverterPOI {

    public POI createdPOI (CreatedPOIDto c){
        POI result = POI.builder()
                .name(c.getNombre())
                .location(c.getLocation())
                .date(c.getFundacion())
                .coverPhoto(c.getCoverPhoto())
                .description(c.getDescripcion())
                .photo2(c.getPhoto2())
                .photo3(c.getPhoto3())
                .build();

        return result;
    }

    public GetPOIDto getPOIDto (POI p){
        GetPOIDto result =  GetPOIDto.builder()
                .id(p.getId())
                .name(p.getName())
                .location(p.getLocation())
                .fundacion(p.getDate())
                .coverPhoto(p.getCoverPhoto())
                .description(p.getDescription())
                .category(p.getCategory()==null?null:p.getCategory().getId())
                .photo2(p.getPhoto2())
                .photo3(p.getPhoto3())
                .build();
        return result;
    }
}
