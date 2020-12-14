<template>
    <ScientificAssessButton :TableRow="TableRow"></ScientificAssessButton>
</template>

<script>
import ScientificAssessButton from '@/components/forms/buttons/assessmentResult/ScientificAssessButton'
export default {
    components:{
        ScientificAssessButton
    },
    props: ["TableRow"],
}
</script>

<style>

</style>