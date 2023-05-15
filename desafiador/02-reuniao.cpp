/*

Precisamos agendar uma reunião de certa duração com um colega de trabalho. 
Temos acesso ao nosso calendário e ao calendário do nosso colega (ambos contendo suas respectivas reuniões do dia, no formato [horaInicial, horaFinal]).
Assim como os limites diários (o horário mais cedo e o mais tarde em que estamos disponíveis para reuniões no formato [horaMaisCedo, horaMaisTarde]).

Essa função receba o nosso calendário, os seus limites diários, o calendário do nosso colega, seus limites diários e a duração da reunião que você desejamos agendar.
Ela retornará uma lista de todos os blocos de tempo ([horaInicial, horaFinal]) durante os quais poderiamos agendar a reunião.
Ordenado do bloco de tempo mais cedo ao mais tarde.

PS: horários fornecidos e retornados no formato 24h.

*/

#include <vector>
#include <string>
#include <algorithm>

using namespace std;

// Estrutura para representar uma reunião com horários de início e fim em string
struct StringMeeting {
    string start;
    string end;
};

// Estrutura para representar uma reunião com horários de início e fim em minutos
struct Meeting {
    int start;
    int end;
};

// Função para converter um horário em string para minutos
int timeToMinutes(string time) {
    int delimiterPos = time.find(":");
    int h = stoi(time.substr(0, delimiterPos));
    int m = stoi(time.substr(delimiterPos + 1));
    return h * 60 + m;
}

// Função para converter minutos para um horário em string
string minutesToTime(int minutes) {
    int h = minutes / 60;
    int m = minutes % 60;
    string res = to_string(h) + ":";
    if (m < 10)
        res += "0";
        res += to_string(m);
    return res;
}

// Função para atualizar o calendário adicionando os limites diários
vector<Meeting> updateCalendar(vector<StringMeeting> calendar, StringMeeting dailyBounds) {
    vector<Meeting> updatedCalendar;
    updatedCalendar.push_back({timeToMinutes("0:00"), timeToMinutes(dailyBounds.start)});
    for (StringMeeting meeting : calendar) {
        updatedCalendar.push_back({timeToMinutes(meeting.start), timeToMinutes(meeting.end)});
    }
    updatedCalendar.push_back({timeToMinutes(dailyBounds.end), timeToMinutes("23:59")});
    return updatedCalendar;
}

// Função para mesclar dois calendários ordenados
vector<Meeting> mergeCalendars(vector<Meeting> calendar1, vector<Meeting> calendar2) {
    vector<Meeting> merged;
    int i = 0, j = 0;
    while (i < calendar1.size() && j < calendar2.size()) {
        Meeting meeting1 = calendar1[i];
        Meeting meeting2 = calendar2[j];
        if (meeting1.start < meeting2.start) {
            merged.push_back(meeting1);
            i++;
        } else {
            merged.push_back(meeting2);
            j++;
        }
    }
    
    while (i < calendar1.size())
        merged.push_back(calendar1[i++]);
        
    while (j < calendar2.size())
        merged.push_back(calendar2[j++]);

        
    return merged;
}

// Função para achatar o calendário mesclado removendo sobreposições
vector<Meeting> flattenCalendar(vector<Meeting> calendar) {
    vector<Meeting> flattened{calendar[0]};
    
    for (int i = 1; i < calendar.size(); i++) {
        Meeting currentMeeting = calendar[i];
        Meeting prevMeeting = flattened[flattened.size() - 1];
        
        if (prevMeeting.end >= currentMeeting.start) {
            Meeting newPrevMeeting{prevMeeting.start, max(prevMeeting.end, currentMeeting.end)};
            flattened[flattened.size() - 1] = newPrevMeeting;
        } else {
            flattened.push_back(currentMeeting);
        }
    
    }
  
    return flattened;
}

// Função para obter os horários disponíveis para a reunião
vector<StringMeeting> getMatchingAvailabilities(vector<Meeting> calendar, int meetingDuration) {

    vector<StringMeeting> matchingAvailabilities;
    
    for (int i = 1; i < calendar.size(); i++) {
        int start = calendar[i - 1].end;
        int end = calendar[i].start;
        int availabilityDuration = end - start;
        
        if (availabilityDuration >= meetingDuration) {
            matchingAvailabilities.push_back({minutesToTime(start), minutesToTime(end)});
        }

    }
    
    return matchingAvailabilities;
}

// Função principal que resolve o problema
vector<StringMeeting> calendarMatching(vector<StringMeeting> calendar1,
                                       StringMeeting dailyBounds1,
                                       vector<StringMeeting> calendar2,
                                       StringMeeting dailyBounds2,
                                       int meetingDuration) {
  
    vector<Meeting> updatedCalendar1 = updateCalendar(calendar1, dailyBounds1);
    vector<Meeting> updatedCalendar2 = updateCalendar(calendar2, dailyBounds2);
    vector<Meeting> mergedCalendar =
    mergeCalendars(updatedCalendar1, updatedCalendar2);
    vector<Meeting> flattenedCalendar = flattenCalendar(mergedCalendar);
    return getMatchingAvailabilities(flattenedCalendar, meetingDuration);

}