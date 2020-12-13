<template>
    <PatentAssessButton :TableRow="TableRow"></PatentAssessButton>
</template>

<script>
import PatentAssessButton from '@/components/forms/buttons/assessmentResult/PatentAssessButton'
export default {
    components:{
        PatentAssessButton
    },
    props: ["TableRow"],
}
</script>

<style>

</style>