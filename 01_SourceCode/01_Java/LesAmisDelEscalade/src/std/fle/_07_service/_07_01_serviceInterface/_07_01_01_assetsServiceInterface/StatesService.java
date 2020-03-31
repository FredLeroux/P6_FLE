package std.fle._07_service._07_01_serviceInterface._07_01_01_assetsServiceInterface;

import std.fle._01_entity._01_01_assetsClasses.States;
import std.fle._02_dto._02_01_assetsClassesDTO.StatesDTO;
import std.fle._05_CRUDInterface.AssetsCRUD;

public interface StatesService extends AssetsCRUD<States, StatesDTO> {

}
