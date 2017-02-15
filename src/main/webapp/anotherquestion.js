/**
 * Created by condor on 04/02/17
 */

function listQuestions(questions) {
    //var list = document.getElementById('listOfQuestions');
    alert('cucubau');
    var list = document.getElementById('listOfQuestions').getElementsByTagName('ul')[0];
    var listHtml = '';

    for (var i = 0; i < questions.length; i++) {
        var question = questions[i];
        //listHtml= listHtml+question+'</br>';

        var el= '<li>'+question+'</li>';
        listHtml=listHtml+el;
    }
    list.innerHTML = listHtml;
}

// cazul cand nu folosim o lista html
function listQuestions1(questions) {
    var list = document.getElementById('listOfQuestions');
    var listHtml = '';

    for (var i = 0; i < questions.length; i++) {
        var question = questions[i];
        listHtml=listHtml+question+'</br>';
    }
    list.innerHTML = listHtml;
}

//aduc jsonul de pe server
function loadQuestions() {
    alert('returnez mesaj');
    $.ajax({
        url: 'aq?action=list'
    }).done(function (response) {
        listQuestions(response.questions);
    });
}


// buggy one
// accepts empty strings
// accepts html code (script injections as well)
/// etc
function addQuestion() {
    alert('adaug intrebarea');
    var questionInput = document.getElementById('questionInput').value;
    var questionResponse = document.getElementById('questionAnswer').value;

    $.ajax({
        url: 'aq?value='+questionInput +'&answer='+questionResponse
    }).done(function (response) {
        location.href = "anotherquestion.html";    //U I
    });
}