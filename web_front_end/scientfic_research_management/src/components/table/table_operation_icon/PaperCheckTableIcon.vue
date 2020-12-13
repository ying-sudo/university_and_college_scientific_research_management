<template>
    <PaperAssessButton :TableRow="TableRow"></PaperAssessButton>
</template>

<script>
import PaperAssessButton from '@/components/forms/buttons/assessmentResult/PaperAssessButton'
export default {
    components:{
        PaperAssessButton
    },
    props: ["TableRow"],
}
</script>

<style>

</style>