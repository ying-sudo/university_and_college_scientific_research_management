export function getTableDataMap() {
    var table_data_map = new Map([
        ["loginlog", "mangerSys/loginlog"], 
        ["systemlog", "mangerSys/syslog"], 
        ["operationlog", "mangerSys/operlog"],  
        
        ["collegesdep", "mangerSys/colleges"], 
        ["researchers", "mangerSys/colleges"], 

        ["roles", "mangerSys/characters/findAll"],    
    ]);

    return table_data_map;
}