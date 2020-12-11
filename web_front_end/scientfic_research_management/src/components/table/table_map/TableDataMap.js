export function getTableDataMap() {
    var table_data_map = new Map([
        ["fundlists", "mangerSys/funds/projects"], 
        ["projectlists", "mangerSys/projects/users"], 
        ["papers", "mangerSys/achievements/paper/users"], 
        ["works", "mangerSys/achievements/work/users"],  
        ["teams", "mangerSys/team"], 
        ["authoritylists", "/api/table_data"], 
        ["scientifics", "mangerSys/achievements/scientific/users"], 
        ["patents", "mangerSys/achievements/patent/users"], 
        
    ]);

    return table_data_map;
}