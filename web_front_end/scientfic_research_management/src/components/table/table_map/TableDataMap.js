export function getTableDataMap() {
    var table_data_map = new Map([
        ["fundlists", "mangerSys/fund/fund"], 
        ["projectlists", "mangerSys/project/projects"], 
        ["papers", "mangerSys/paperAchievement/findOne"], 
        ["works", "mangerSys/workAchievement/findOne"], 
        ["loginlog", "mangerSys/loginlog"], 
        ["systemlog", "mangerSys/syslog"], 
        ["operationlog", "mangerSys/operlog"], 
        ["teams", "mangerSys/team"], 
        ["authoritylists", "/api/table_data"], 
        ["scientifics", "mangerSys/scientAchieve"], 
        ["patents", "mangerSys/patentAchievement"], 
        
              
    ]);

    return table_data_map;
}