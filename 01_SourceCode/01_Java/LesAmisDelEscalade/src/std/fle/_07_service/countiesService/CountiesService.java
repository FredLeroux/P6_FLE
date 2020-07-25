package std.fle._07_service.countiesService;

import std.fle._01_entity.assetsClasses.Counties;
import std.fle._02_dto.assetsClassesDTO.CountiesDTO;
import std.fle._06_dao.CRUDInterface.AssetsCRUD;

public interface CountiesService extends AssetsCRUD<Counties, CountiesDTO> {

}
