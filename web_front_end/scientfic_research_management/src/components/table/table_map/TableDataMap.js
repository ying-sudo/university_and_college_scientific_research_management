export function getTableDataMap() {
    var table_data_map = new Map([
        ["fundlists", "/api/table_data"], 
        ["authoritylists", "/api/table_data"], 
        ["projectlists", "mangerSys/project/projects"], 
        
    ]);

    return table_data_map;
}