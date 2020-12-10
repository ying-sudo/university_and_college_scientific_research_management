export function getTableDataMap() {
    var table_data_map = new Map([
        ["loginlog", "mangerSys/loginlog"], 
        ["systemlog", "mangerSys/syslog"], 
        ["operationlog", "mangerSys/operlog"],      
    ]);

    return table_data_map;
}