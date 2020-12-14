export function getTableDataMap() {
    var table_data_map = new Map([
        ["projectlists", "/api/table_data/project"], 
        ["fundlists", "/api/table_data/funds"], 
        ["papers", "mangerSys/achievements/paper/users"], 
        ["works", "mangerSys/achievements/work/users"],  
        ["teams", "mangerSys/team"], 
        ["authoritylists", "/api/table_data"], 
        ["scientifics", "mangerSys/achievements/scientific/users"], 
        ["patents", "mangerSys/achievements/patent/users"], 
        ["project_result", "/api/table_data/project_check_result"], 
        
        
    ]);

    return table_data_map;
}