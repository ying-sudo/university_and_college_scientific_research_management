<template>
    <SingleDelete :TableRow="TableRow"></SingleDelete>
</template>

<script>
import SingleDelete from '@/components/table/batch_delete/SingleDelete'
export default {
    components:{
        SingleDelete
    },
    props: ["TableRow"],
}
</script>

<style>

</style>