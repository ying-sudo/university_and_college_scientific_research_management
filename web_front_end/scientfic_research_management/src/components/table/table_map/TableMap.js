//返回URL与需要加载的表格json的对应关系
export function getTableMap() {
    var table_map = new Map([
        ["/projectlists", "/project_table/ProjectTable.json"],
        ["/fundlists", "/funds_table/FundsTable.json"],
        ["/authoritylists", "/authority_table/AuthorityTable.json"], 
    ]);

    return table_map;
}
