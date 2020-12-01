export function getTableDataMap() {
    var table_data_map = new Map([
        ["fundlists", "mangerSys/fund/fund"], 
        ["authoritylists", "/api/table_data"], 
        ["projectlists", "mangerSys/project/projects"], 
        ["papers", "mangerSys/paperAchievement/findOne"], 
        ["works", "mangerSys/workAchievement/findOne"], 
        ["loginlog", "mangerSys/operlog"], 
        ["systemlog", "mangerSys/syslog"], 
        
        
    ]);

    return table_data_map;
}