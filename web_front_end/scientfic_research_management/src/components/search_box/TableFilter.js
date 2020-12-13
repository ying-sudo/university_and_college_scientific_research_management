export function getfilterMap() {
    var filter_map = new Map([
        ["projectlists", [
            {
                value: "id",
                label: "项目编号",
            }, {
                value: "name",
                label: "项目名称",
            },
        ]], 

        ["fundlists", [
            {
                value: "projectId",
                label: "项目编号",
            }, {
                value: "projectName",
                label: "项目名称",
            },
        ]],

        ["papers", [
            {
                value: "id",
                label: "论文编号",
            }, {
                value: "name",
                label: "论文名称",
            },
        ]],

        ["works", [
            {
                value: "id",
                label: "著作编号",
            }, {
                value: "name",
                label: "著作名称",
            },
        ]],

        ["patents", [
            {
                value: "id",
                label: "专利产品编号",
            }, {
                value: "name",
                label: "专利产品名称",
            },
        ]],

        ["scientifics", [
            {
                value: "id",
                label: "科研成果编号",
            }, {
                value: "name",
                label: "科研成果名称",
            },
        ]],

        ["teams", [
            {
                value: "id",
                label: "科研成果编号",
            }, {
                value: "name",
                label: "科研成果名称",
            },
        ]],
    ]);

    return filter_map;
}