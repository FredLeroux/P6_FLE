package std.fle._07_service.statesService;

import std.fle._01_entity.assetsClasses.States;
import std.fle._02_dto.assetsClassesDTO.StatesDTO;
import std.fle._06_dao.CRUDInterface.AssetsCRUD;

public interface StatesService extends AssetsCRUD<States, StatesDTO> {

}
