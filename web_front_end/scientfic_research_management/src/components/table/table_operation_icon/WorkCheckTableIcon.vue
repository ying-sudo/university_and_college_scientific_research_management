<template>
    <WorkAssessButton :TableRow="TableRow"></WorkAssessButton>
</template>

<script>
import WorkAssessButton from '@/components/forms/buttons/assessmentResult/WorkAssessButton'
export default {
    components:{
        WorkAssessButton
    },
    props: ["TableRow"],
}
</script>

<style>

</style>