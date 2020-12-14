<template>
    <TeamAssessButton :TableRow="TableRow"></TeamAssessButton>
</template>

<script>
import TeamAssessButton from '@/components/forms/buttons/assessmentResult/TeamAssessButton'
export default {
    components:{
        TeamAssessButton
    },
    props: ["TableRow"],
}
</script>

<style>

</style>