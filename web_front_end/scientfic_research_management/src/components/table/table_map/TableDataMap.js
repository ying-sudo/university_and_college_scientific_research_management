export function getTableDataMap() {
    var table_data_map = new Map([
        ["fundlists", "mangerSys/fund/fund"], 
        ["authoritylists", "/api/table_data"], 
        ["projectlists", "mangerSys/project/projects"], 
        ["papers", "mangerSys/paperAchievement/findOne"], 
        ["works", "mangerSys/workAchievement/findOne"], 
        ["loginlog", "mangerSys/loginlog"], 
        ["systemlog", "mangerSys/syslog"], 
        ["operationlog", "mangerSys/operlog"], 
        
        
    ]);

    return table_data_map;
}