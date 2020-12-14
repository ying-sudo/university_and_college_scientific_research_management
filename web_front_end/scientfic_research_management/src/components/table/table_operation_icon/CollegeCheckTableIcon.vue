<template>
    <CollegeAssessButton :TableRow="TableRow"></CollegeAssessButton>
</template>

<script>
import CollegeAssessButton from '@/components/forms/buttons/assessmentResult/CollegeAssessButton'
export default {
    components:{
        CollegeAssessButton
    },
    props: ["TableRow"],
}
</script>

<style>

</style>