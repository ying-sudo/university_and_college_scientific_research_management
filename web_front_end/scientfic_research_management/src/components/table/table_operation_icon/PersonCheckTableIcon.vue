<template>
    <PersonalAssessButton :TableRow="TableRow"></PersonalAssessButton>
</template>

<script>
import PersonalAssessButton from '@/components/forms/buttons/assessmentResult/PersonalAssessButton'
export default {
    components:{
        PersonalAssessButton
    },
    props: ["TableRow"],
}
</script>

<style>

</style>